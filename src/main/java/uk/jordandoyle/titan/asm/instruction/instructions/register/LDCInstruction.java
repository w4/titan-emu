package uk.jordandoyle.titan.asm.instruction.instructions.register;

import uk.jordandoyle.titan.asm.instruction.Instruction;

/**
 * Loads #xZZ into Rd.
 */
public final class LDCInstruction implements Instruction {
    private static final byte OPCODE = 0b1010;
    private static final byte COND = 0b0;

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
        return true;
    }

    @Override
    public Class[] getOperandTypes() {
        return new Class[] { byte.class, byte.class };
    }
}

