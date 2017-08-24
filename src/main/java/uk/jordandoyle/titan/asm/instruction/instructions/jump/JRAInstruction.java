package uk.jordandoyle.titan.asm.instruction.instructions.jump;

import uk.jordandoyle.titan.asm.instruction.Instruction;

/**
 * Jump autoincrement, Jump to the address made up from Rh and Rl, then increment Rh Rl (as 16bit value)
 */
public final class JRAInstruction implements Instruction {
    private static final byte OPCODE = 0b1011;
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
        return new Class[] { byte.class };
    }
}
