package uk.jordandoyle.titan.asm.instruction.instructions.register;

import uk.jordandoyle.titan.asm.instruction.Instruction;

/**
 * Moves Rs into Rd.
 */
public final class MOVInstruction implements Instruction {
    private static final byte OPCODE = 0b1001;
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

