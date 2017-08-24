package uk.jordandoyle.titan.asm.instruction.instructions.arithmetic;

import uk.jordandoyle.titan.asm.instruction.Instruction;

/**
 * Invert/Complement of source register.
 */
public final class NOTInstruction implements Instruction {
    private static final byte OPCODE = 0b1;
    private static final byte COND = 0b110;

    @Override
    public byte getOpcode() {
        return OPCODE;
    }

    @Override
    public byte getCond() {
        return COND;
    }

    @Override
    public boolean useCondAsOperand() {
        return false;
    }

    @Override
    public Class[] getOperandTypes() {
        return new Class[] { byte.class };
    }
}
