package GUI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TugasAntreanRS extends JFrame {
    private Queue<String> antrian = new ArrayDeque<>();
    private ArrayList<String> antrianSelesai = new ArrayList<>();
    private String pasienSedangDiproses = null;
    private int nomorAntrian = 1;
    private JTextArea textArea;

    public TugasAntreanRS() {
        setTitle("Antrean Rumah Sakit");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton tambahButton = new JButton("Tambah Pasien");
        JButton panggilButton = new JButton("Panggil Berikutnya");
        JButton daftarButton = new JButton("Daftar Antrian");
        JButton diprosesButton = new JButton("Pasien Sedang Diproses");
        JButton selesaiButton = new JButton("Antrian Selesai");
        JButton resetButton = new JButton("Reset Antrian");
        JButton keluarButton = new JButton("Keluar");

        textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);

        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7, 1));
        buttonPanel.add(tambahButton);
        buttonPanel.add(panggilButton);
        buttonPanel.add(daftarButton);
        buttonPanel.add(diprosesButton);
        buttonPanel.add(selesaiButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(keluarButton);

        panel.add(buttonPanel, BorderLayout.EAST);

        tambahButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pasien = JOptionPane.showInputDialog("Masukkan nama pasien:");
                if (pasien != null && !pasien.isEmpty()) {
                    antrian.offer(pasien);
                    textArea.append("Pasien " + pasien + " ditambahkan ke antrian.\n");
                    saveData(pasien, nomorAntrian);
                    nomorAntrian++;
                }
            }
        });

        panggilButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!antrian.isEmpty()) {
                    pasienSedangDiproses = antrian.poll();
                    textArea.append("Pasien " + pasienSedangDiproses + " dipanggil.\n");
                    antrianSelesai.add(pasienSedangDiproses);
                } else {
                    textArea.append("Antrian kosong.\n");
                }
            }
        });

        daftarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("Daftar Antrian:\n");
                for (String p : antrian) {
                    textArea.append(p + "\n");
                }
            }
        });

        diprosesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pasienSedangDiproses != null) {
                    textArea.append("Pasien yang sedang diproses: " + pasienSedangDiproses + "\n");
                } else {
                    textArea.append("Tidak ada pasien yang sedang diproses.\n");
                }
            }
        });

        selesaiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("Antrian yang sudah selesai:\n");
                for (String p : antrianSelesai) {
                    if (!p.equals(pasienSedangDiproses)) {
                        textArea.append(p + "\n");
                    }
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                antrian.clear();
                antrianSelesai.clear();
                pasienSedangDiproses = null;
                nomorAntrian = 1;
                textArea.setText("Antrian telah direset.\n");
            }
        });

        keluarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(panel);
        setVisible(true);
    }

    private void saveData(String namaPasien, int nomorAntrian) {
        LocalDate tanggal = LocalDate.now();
        LocalTime waktu = LocalTime.now();
        File folder = new File("dataAntreanRS");
        if (!folder.exists()) {
            folder.mkdir();
        }
        File file = new File(folder, "antrianRS.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write("Nomor Antrian: " + nomorAntrian + "\n");
            writer.write("Nama Pasien: " + namaPasien + "\n");
            writer.write("Tanggal: " + tanggal + "\n");
            writer.write("Waktu: " + waktu + "\n");
            writer.write("--------------------\n");
        } catch (IOException e) {
            textArea.append("Terjadi kesalahan saat menyimpan data: " + e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TugasAntreanRS();
            }
        });
    }
}
