package uk.jordandoyle.titan.asm.instruction;

public interface Instruction {
    /**
     * Opcode that matches this instruction.
     *
     * @return opcode
     */
    byte getOpcode();

    /**
     * Condition that matches this instruction. This method will return null if this instruction doesn't
     * use a condition.
     *
     * @return condition
     */
    byte getCond();

    /**
     * Whether or not the condition of this instruction should instead be used as an operand. Normally
     * used for source/destination for stack operations.
     *
     * @return true, if we should use the condition as an operand
     */
    boolean useCondAsOperand();

    /**
     * Operand count of this instruction.
     *
     * @return operand count
     */
    Class[] getOperandTypes();
}
