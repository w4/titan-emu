package uk.jordandoyle.titan.asm;

import com.google.common.base.CharMatcher;
import com.google.common.io.BaseEncoding;
import uk.jordandoyle.titan.asm.instruction.Instruction;
import uk.jordandoyle.titan.asm.instruction.InstructionFactory;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;

public final class Assembly {
    private Deque<Instruction> instructions = new ArrayDeque<>();

    public void parseString(String instruction) throws IllegalAccessException, InstantiationException {
        ByteBuffer bytes = ByteBuffer.wrap(BaseEncoding.base16().decode(CharMatcher.whitespace().removeFrom(instruction)));

        while (bytes.hasRemaining()) {
            int b = Byte.toUnsignedInt(bytes.get());

            System.out.println("PARSING: " + Integer.toBinaryString(b) + " - " + Integer.toHexString(b));

            // get the first nibble from the byte
            byte highNibble = (byte) ((b >> 4) & 0x0F);
            System.out.println("Opcode: " + String.format("%4s", Integer.toBinaryString(highNibble)).replace(' ', '0'));

            // get the second nibble from the byte
            byte lowNibble = (byte) (b & 0x0F);
            System.out.println("Low nibble: " + String.format("%4s", Integer.toBinaryString(lowNibble)).replace(' ', '0'));

            Instruction i = this.getInstruction(highNibble, lowNibble);

            if (i == null) {
                System.out.println("---");
                continue;
            }

            Class<?>[] types = i.getOperandTypes();

            System.out.println("Parameters: " + types.length);

            for (int n = 0; n < types.length; n++) {
                if (n == 0 && i.useCondAsOperand()) {
                    System.out.println("Param: " + String.format("%4s", Integer.toBinaryString(lowNibble)).replace(' ', '0'));
                    continue;
                }

                Class<?> type = types[n];

                if (type.isAssignableFrom(byte.class)) {
                    byte param = bytes.get();

                    System.out.println("Param: " + String.format("%8s", Integer.toBinaryString(param)).replace(' ', '0'));

                    // get the first nibble from the byte
                    byte paramHighNibble = (byte) ((param >> 4) & 0x0F);
                    System.out.println(String.format(">  Low nibble: %4s (%s)",
                                                     Integer.toBinaryString(paramHighNibble),
                                                     Integer.toHexString(paramHighNibble)));

                    // get the second nibble from the byte
                    byte paramLowNibble = (byte) (param & 0x0F);
                    System.out.println(String.format(">  Low nibble: %4s (%s)",
                                                     Integer.toBinaryString(paramLowNibble),
                                                     Integer.toHexString(paramLowNibble)));
                } else if (type.isAssignableFrom(short.class)) {
                    // get the next 2 bytes and convert them to an int
                    int param = ((bytes.get() & 0xFF) << 8) + (bytes.get() & 0xFF);
                    System.out.println("Param: (short) " + param);
                } else {
                    System.out.println("ERROR: Class wanted " + type.getName() + " - we couldn't provide it.");
                    byte param = bytes.get();

                    System.out.println("Param: " + String.format("%8s", Integer.toBinaryString(param)).replace(' ', '0'));
                }
            }

            System.out.println("---");
        }
    }

    private Instruction getInstruction(byte highNibble, byte lowNibble) throws IllegalAccessException, InstantiationException {
        for (InstructionFactory.InstructionType f : InstructionFactory.InstructionType.values()) {
            Instruction i = f.getInstruction().newInstance();

            if (i.getOpcode() == highNibble && (i.useCondAsOperand() || i.getCond() == lowNibble)) {
                System.out.println("Added " + f.name());
                return i;
            }
        }

        System.out.println("ERROR: couldn't find instruction for op " + highNibble + ", cond " + lowNibble);

        return null;
    }
}
