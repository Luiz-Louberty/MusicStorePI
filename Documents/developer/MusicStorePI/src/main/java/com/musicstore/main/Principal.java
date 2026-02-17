package com.musicstore.main;

import com.musicstore.view.LoginView;

public class Principal {

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Inicia a execução da tela de Login de forma segura dentro da 
           Event Dispatch Thread (EDT) do Java Swing.
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Cria e exibe a tela de Login como ponto de entrada
                LoginView telaLogin = new LoginView();
                telaLogin.setLocationRelativeTo(null); // Centraliza a tela no monitor
                telaLogin.setVisible(true);
            }
        });

        // Log informativo no console para o desenvolvedor
        System.out.println("SISTEMA MUSICSTORE: Interface Gráfica Iniciada.");
    }
}
