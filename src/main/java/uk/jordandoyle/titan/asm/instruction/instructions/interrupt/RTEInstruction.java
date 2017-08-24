package uk.jordandoyle.titan.asm.instruction.instructions.interrupt;

import uk.jordandoyle.titan.asm.instruction.Instruction;

/**
 * Return from exception/interrupt.
 */
public final class RTEInstruction implements Instruction {
    private static final byte OPCODE = 0b0;
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
        return new Class[] { };
    }
}
