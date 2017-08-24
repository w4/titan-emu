package uk.jordandoyle.titan.asm.instruction.instructions.jump;

import uk.jordandoyle.titan.asm.instruction.Instruction;

/**
 * Jump register, Jump to the address made up from Rh(Register highbyte) and Rl(Register lowbyte).
 */
public final class JMRInstruction implements Instruction {
    private static final byte OPCODE = 0b1011;
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
        return new Class[] { byte.class };
    }
}
