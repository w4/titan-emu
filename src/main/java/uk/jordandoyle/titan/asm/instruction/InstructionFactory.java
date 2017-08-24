package uk.jordandoyle.titan.asm.instruction;

import uk.jordandoyle.titan.asm.instruction.instructions.arithmetic.ADCInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.arithmetic.ADDInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.arithmetic.ANDInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.arithmetic.DECInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.arithmetic.INCInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.arithmetic.IORInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.arithmetic.NOTInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.arithmetic.SHRInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.arithmetic.SUBInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.arithmetic.XORInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.ctrl.HLTInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.ctrl.NOPInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.interrupt.INTInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.interrupt.RTEInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.jump.JMCInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.jump.JMOInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.jump.JMPInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.jump.JMRInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.jump.JMSInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.jump.JMZInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.jump.JRAInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.jump.JSRInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.jump.RSBInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.memory.load.LDMInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.memory.load.LDRInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.memory.load.LMOInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.memory.load.LRAInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.memory.store.SMOInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.memory.store.SRAInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.memory.store.STMInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.memory.store.STRInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.register.CLRInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.register.LDCInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.register.MOVInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.stack.data.PEKInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.stack.data.POPInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.stack.data.PSHInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.stack.ret.PKRInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.stack.ret.PPRInstruction;
import uk.jordandoyle.titan.asm.instruction.instructions.stack.ret.PSRInstruction;

public final class InstructionFactory {
    public enum InstructionType {
        // Arithmetic
        ADC(ADCInstruction.class),
        ADD(ADDInstruction.class),
        AND(ANDInstruction.class),
        DEC(DECInstruction.class),
        INC(INCInstruction.class),
        IOR(IORInstruction.class),
        NOT(NOTInstruction.class),
        SHR(SHRInstruction.class),
        SUB(SUBInstruction.class),
        XOR(XORInstruction.class),

        // CPU Control
        HLT(HLTInstruction.class),
        NOP(NOPInstruction.class),

        // Interrupt
        INT(INTInstruction.class),
        RTE(RTEInstruction.class),

        // Jump
        JMC(JMCInstruction.class),
        JMI(JMCInstruction.class),
        JMO(JMOInstruction.class),
        JMP(JMPInstruction.class),
        JMR(JMRInstruction.class),
        JMS(JMSInstruction.class),
        JMZ(JMZInstruction.class),
        JRA(JRAInstruction.class),
        JSR(JSRInstruction.class),
        RSB(RSBInstruction.class),

        // Memory - load
        LDM(LDMInstruction.class),
        LDR(LDRInstruction.class),
        LMO(LMOInstruction.class),
        LRA(LRAInstruction.class),

        // Memory - store
        SMO(SMOInstruction.class),
        SRA(SRAInstruction.class),
        STM(STMInstruction.class),
        STR(STRInstruction.class),

        // Register
        CLR(CLRInstruction.class),
        LDC(LDCInstruction.class),
        MOV(MOVInstruction.class),

        // Stack - data
        PEK(PEKInstruction.class),
        POP(POPInstruction.class),
        PSH(PSHInstruction.class),

        // Stack - return
        PKR(PKRInstruction.class),
        PPR(PPRInstruction.class),
        PSR(PSRInstruction.class);

        private Class<? extends Instruction> instruction;

        InstructionType(Class<? extends Instruction> instructionClass) {
            this.instruction = instructionClass;
        }

        public Class<? extends Instruction> getInstruction() {
            return this.instruction;
        }
    }
}
