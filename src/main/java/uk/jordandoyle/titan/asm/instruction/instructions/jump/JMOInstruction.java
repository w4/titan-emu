package uk.jordandoyle.titan.asm.instruction.instructions.jump;

import uk.jordandoyle.titan.asm.instruction.Instruction;

/**
 * Jump offset, Jump to address: #xZZZZ + RhRl
 */
public final class JMOInstruction implements Instruction {
    private static final byte OPCODE = 0b1011;
    private static final byte COND = 0b100;

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
        return new Class[] { byte.class, short.class };
    }
}
