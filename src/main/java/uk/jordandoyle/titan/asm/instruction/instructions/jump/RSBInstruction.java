package uk.jordandoyle.titan.asm.instruction.instructions.jump;

import uk.jordandoyle.titan.asm.instruction.Instruction;

/**
 * Return from subroutube, pop address off return stack to Program Counter.
 */
public final class RSBInstruction implements Instruction {
    private static final byte OPCODE = 0b1011;
    private static final byte COND = 0b1001;

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
