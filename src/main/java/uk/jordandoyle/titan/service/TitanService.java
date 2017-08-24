package uk.jordandoyle.titan.service;

import uk.jordandoyle.titan.asm.Assembly;

import javax.inject.Inject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TitanService {
    private Assembly asm;
    private byte[] memory = new byte[0xFFFF];
    private byte[] registers = new byte[0xF];
    private Deque<Byte> stack = new ArrayDeque<>();

    @Inject
    private TitanService(Assembly asm) {
        this.asm = asm;
    }

    public void run() {
        try (Stream<String> stream = Files.lines(Paths.get("~/asm"))) {
            String hex = stream.map(s -> s.split(" : ")[1]).collect(Collectors.joining(""));
            System.out.println(hex);
            this.asm.parseString(hex);
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
