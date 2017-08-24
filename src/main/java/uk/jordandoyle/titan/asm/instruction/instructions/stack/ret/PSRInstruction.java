package uk.jordandoyle.titan.asm.instruction.instructions.stack.ret;

import uk.jordandoyle.titan.asm.instruction.Instruction;

/**
 * Pushes Rs onto the data stack.
 */
public final class PSRInstruction implements Instruction {
    private static final byte OPCODE = 0b101;
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
