package GUI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

public class TugasAntreanRS {
    private static Queue<String> antrian = new ArrayDeque<>();
    private static ArrayList<String> antrianSelesai = new ArrayList<>();
    private static String pasienSedangDiproses = null;

   