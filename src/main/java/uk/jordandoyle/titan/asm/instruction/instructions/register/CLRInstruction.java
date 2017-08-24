package uk.jordandoyle.titan.asm.instruction.instructions.register;

import uk.jordandoyle.titan.asm.instruction.Instruction;

/**
 * Clears Rs.
 */
public final class CLRInstruction implements Instruction {
    private static final byte OPCODE = 0b1000;
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
        return new Class[] { byte.class };
    }
}

