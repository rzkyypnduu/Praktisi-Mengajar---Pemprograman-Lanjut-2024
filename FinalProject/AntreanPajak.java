package FinalProject;

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

public class AntreanPajak extends JFrame {
    private Queue<String> antrian = new ArrayDeque<>();
    private ArrayList<String> antrianSelesai = new ArrayList<>();
    private String wajibPajakSedangDiproses = null;
    private int nomorAntrian = 1;
    private JTextArea textArea;

    public AntreanPajak() {
        setTitle("Antrean Pajak");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton tambahButton = new JButton("Tambah Wajib Pajak");
        JButton panggilButton = new JButton("Panggil Berikutnya");
        JButton daftarButton = new JButton("Daftar Antrian");
        JButton diprosesButton = new JButton("Wajib Pajak Sedang Diproses");
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
                String wajibPajak = JOptionPane.showInputDialog("Masukkan nama wajib pajak:");
                if (wajibPajak != null && !wajibPajak.isEmpty()) {
                    antrian.offer(wajibPajak);
                    // Log dihapus
                    saveData(wajibPajak, nomorAntrian);
                    nomorAntrian++;
                }
            }
        });

        panggilButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!antrian.isEmpty()) {
                    wajibPajakSedangDiproses = antrian.poll();
                    // Log dihapus
                    antrianSelesai.add(wajibPajakSedangDiproses);
                } else {
                    // Log dihapus
                }
            }
        });

        daftarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("Daftar Antrian:\n");
                for (String p : antrian) {
                    textArea.append(p + "\n");
                }
            }
        });

        diprosesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (wajibPajakSedangDiproses != null) {
                    textArea.setText("Wajib Pajak yang sedang diproses: " + wajibPajakSedangDiproses + "\n");
                } else {
                    textArea.setText("Tidak ada wajib pajak yang sedang diproses.\n");
                }
            }
        });

        selesaiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("Antrian yang sudah selesai:\n");
                for (String p : antrianSelesai) {
                    if (!p.equals(wajibPajakSedangDiproses)) {
                        textArea.append(p + "\n");
                    }
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                antrian.clear();
                antrianSelesai.clear();
                wajibPajakSedangDiproses = null;
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

    private void saveData(String namaWajibPajak, int nomorAntrian) {
        LocalDate tanggal = LocalDate.now();
        LocalTime waktu = LocalTime.now();
        File folder = new File("dataAntreanPajak");
        if (!folder.exists()) {
            folder.mkdir();
        }
        File file = new File(folder, "antrianPajak.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write("Nomor Antrian: " + nomorAntrian + "\n");
            writer.write("Nama Wajib Pajak: " + namaWajibPajak + "\n");
            writer.write("Tanggal: " + tanggal + "\n");
            writer.write("Waktu: " + waktu + "\n");
            writer.write("--------------------\n");
        } catch (IOException e) {
            // Log dihapus
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AntreanPajak();
            }
        });
    }
}

