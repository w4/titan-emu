package uk.jordandoyle.titan.asm.instruction.instructions.memory.load;

import uk.jordandoyle.titan.asm.instruction.Instruction;

/**
 * Load the contents of the address #xZZZZ + RhRl into Rd.
 */
public final class LMOInstruction implements Instruction {
    private static final byte OPCODE = 0b1100;
    private static final byte COND = 0b10;

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
