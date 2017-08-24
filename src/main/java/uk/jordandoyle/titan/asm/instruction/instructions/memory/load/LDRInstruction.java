package uk.jordandoyle.titan.asm.instruction.instructions.memory.load;

import uk.jordandoyle.titan.asm.instruction.Instruction;

/**
 * Load the contents of the address made up from Rh and Rl into Rd.
 */
public final class LDRInstruction implements Instruction {
    private static final byte OPCODE = 0b1100;
    private static final byte COND = 0b1;

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
        return new Class[] { byte.class, byte.class };
    }
}
