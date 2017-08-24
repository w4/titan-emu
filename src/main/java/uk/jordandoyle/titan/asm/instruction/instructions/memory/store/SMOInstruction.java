package uk.jordandoyle.titan.asm.instruction.instructions.memory.store;

import uk.jordandoyle.titan.asm.instruction.Instruction;

/**
 * Store Rs to address #xZZZZ + RhRl.
 */
public final class SMOInstruction implements Instruction {
    private static final byte OPCODE = 0b1101;
    private static final byte COND = 0b11;

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
        return new Class[] { byte.class, byte.class, short.class };
    }
}
