package uk.jordandoyle.titan.asm.instruction.instructions.ctrl;

import uk.jordandoyle.titan.asm.instruction.Instruction;

/**
 * Performs a No Operation.
 */
public final class NOPInstruction implements Instruction {
    private static final byte OPCODE = 0b0;
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
        return false;
    }

    @Override
    public Class[] getOperandTypes() {
        return new Class[] {};
    }
}
