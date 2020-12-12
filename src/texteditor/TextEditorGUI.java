package texteditor;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

public class TextEditorGUI extends javax.swing.JFrame implements Runnable{
    
    String fileName = "New File";
    File savedFilePath;
    boolean fileSaved = false;
    //boolean musicOnly = false;
    Thread thread;
    MakeSound play;
    Clipboard clipboard = getToolkit().getSystemClipboard();
    String currentSavedFileContent = "";
    
    public TextEditorGUI() {
        
        initComponents();
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                exitProgram();
                
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuFileNew = new javax.swing.JMenuItem();
        menuFileNewWindow = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuFileOpen = new javax.swing.JMenuItem();
        menuFileSave = new javax.swing.JMenuItem();
        menuFileSaveAs = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuFileExit = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        menuEditSelectAll = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        menuEditCopy = new javax.swing.JMenuItem();
        menuEditCut = new javax.swing.JMenuItem();
        menuEditPaste = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuEditSearch = new javax.swing.JMenuItem();
        menuEditClearSearch = new javax.swing.JMenuItem();
        menuInsert = new javax.swing.JMenu();
        menuInsertHTML = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        menuHelpAbout = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(60, 63, 66));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(100, 20));

        menuFile.setForeground(new java.awt.Color(0, 0, 0));
        menuFile.setText("  File");
        menuFile.setName(""); // NOI18N
        menuFile.setPreferredSize(new java.awt.Dimension(50, 30));

        menuFileNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuFileNew.setText("New");
        menuFileNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileNewActionPerformed(evt);
            }
        });
        menuFile.add(menuFileNew);

        menuFileNewWindow.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuFileNewWindow.setText("New Window");
        menuFileNewWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileNewWindowActionPerformed(evt);
            }
        });
        menuFile.add(menuFileNewWindow);
        menuFile.add(jSeparator2);

        menuFileOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuFileOpen.setText("Open");
        menuFileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileOpenActionPerformed(evt);
            }
        });
        menuFile.add(menuFileOpen);

        menuFileSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuFileSave.setText("Save");
        menuFileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileSaveActionPerformed(evt);
            }
        });
        menuFile.add(menuFileSave);

        menuFileSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuFileSaveAs.setText("Save As...");
        menuFileSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileSaveAsActionPerformed(evt);
            }
        });
        menuFile.add(menuFileSaveAs);
        menuFile.add(jSeparator3);

        menuFileExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuFileExit.setText("Exit");
        menuFileExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileExitActionPerformed(evt);
            }
        });
        menuFile.add(menuFileExit);

        jMenuBar1.add(menuFile);

        menuEdit.setForeground(new java.awt.Color(0, 0, 0));
        menuEdit.setText("  Edit");
        menuEdit.setPreferredSize(new java.awt.Dimension(50, 30));

        menuEditSelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuEditSelectAll.setText("Select All");
        menuEditSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditSelectAllActionPerformed(evt);
            }
        });
        menuEdit.add(menuEditSelectAll);
        menuEdit.add(jSeparator5);

        menuEditCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuEditCopy.setText("Copy");
        menuEditCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditCopyActionPerformed(evt);
            }
        });
        menuEdit.add(menuEditCopy);

        menuEditCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuEditCut.setText("Cut");
        menuEditCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditCutActionPerformed(evt);
            }
        });
        menuEdit.add(menuEditCut);

        menuEditPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuEditPaste.setText("Paste");
        menuEditPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditPasteActionPerformed(evt);
            }
        });
        menuEdit.add(menuEditPaste);
        menuEdit.add(jSeparator1);

        menuEditSearch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuEditSearch.setText("Search");
        menuEditSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditSearchActionPerformed(evt);
            }
        });
        menuEdit.add(menuEditSearch);

        menuEditClearSearch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuEditClearSearch.setText("Clear Search");
        menuEditClearSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditClearSearchActionPerformed(evt);
            }
        });
        menuEdit.add(menuEditClearSearch);

        jMenuBar1.add(menuEdit);

        menuInsert.setForeground(new java.awt.Color(0, 0, 0));
        menuInsert.setText("Insert");
        menuInsert.setMinimumSize(new java.awt.Dimension(50, 30));
        menuInsert.setPreferredSize(new java.awt.Dimension(50, 30));

        menuInsertHTML.setText("Insert HTML template");
        menuInsertHTML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInsertHTMLActionPerformed(evt);
            }
        });
        menuInsert.add(menuInsertHTML);

        jMenuBar1.add(menuInsert);

        menuHelp.setForeground(new java.awt.Color(0, 0, 0));
        menuHelp.setText("  Help");
        menuHelp.setPreferredSize(new java.awt.Dimension(50, 30));

        menuHelpAbout.setText("About");
        menuHelpAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHelpAboutActionPerformed(evt);
            }
        });
        menuHelp.add(menuHelpAbout);

        jMenuBar1.add(menuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuFileNewWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileNewWindowActionPerformed
        newWindow();
    }//GEN-LAST:event_menuFileNewWindowActionPerformed

    private void menuEditSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditSelectAllActionPerformed
        this.jTextArea1.selectAll();
        
    }//GEN-LAST:event_menuEditSelectAllActionPerformed

    private void menuHelpAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHelpAboutActionPerformed
        Thread newThread = new Thread(this);
        thread = newThread;
        thread.start();
        
        playSound("src/texteditor/resources/deWe - Grebykiosken 1996.wav");
        
        
    }//GEN-LAST:event_menuHelpAboutActionPerformed

    private void menuFileOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileOpenActionPerformed
        saveQuestion();
        openFile();
    }//GEN-LAST:event_menuFileOpenActionPerformed

    private void menuFileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileSaveActionPerformed
        saveFile();
    }//GEN-LAST:event_menuFileSaveActionPerformed

    private void menuFileExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileExitActionPerformed
        exitProgram();
    }//GEN-LAST:event_menuFileExitActionPerformed

    private void menuEditCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditCutActionPerformed
        String cutString = jTextArea1.getSelectedText();
        StringSelection cutselection = new StringSelection(cutString);
        //clipboard deklarerad under klassen
        clipboard.setContents(cutselection, cutselection);
        jTextArea1.replaceRange("", jTextArea1.getSelectionStart(), jTextArea1.getSelectionEnd());
        
    }//GEN-LAST:event_menuEditCutActionPerformed

    private void menuEditPasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditPasteActionPerformed
        try {
            Transferable pasteText = clipboard.getContents(TextEditorGUI.this);
            String sel = (String) pasteText.getTransferData(DataFlavor.stringFlavor);
            jTextArea1.replaceRange(sel, jTextArea1.getSelectionStart(), jTextArea1.getSelectionEnd());
        } catch (Exception e) {
            System.out.println("Klistra in misslyckades. Tråkigt =( ");
        }
    }//GEN-LAST:event_menuEditPasteActionPerformed

    private void menuEditCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditCopyActionPerformed
        String copyText = jTextArea1.getSelectedText();
        StringSelection copySelection = new StringSelection (copyText);
        clipboard.setContents(copySelection, copySelection);
    }//GEN-LAST:event_menuEditCopyActionPerformed

    private void menuFileNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileNewActionPerformed
        newFile();
    }//GEN-LAST:event_menuFileNewActionPerformed

    private void menuInsertHTMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInsertHTMLActionPerformed
        
        if(saveQuestion()){
            fileName = "New HTML Template";
            String htmlTemplate = "<HTML>\n        <HEAD><TITLE>My WebPage</TITLE></HEAD>\n        <BODY>\n                <P>Text goes here</P>\n        </BODY>\n</HTML>\n";
            this.jTextArea1.setText(htmlTemplate);
            this.setTitle("deWe Editor -> " + fileName);
            //Sparar strängen htmlTemplate för att kunna jämföra om ändringar har gjorts när programmet stängs
            currentSavedFileContent = htmlTemplate;
            //Sätter fileSaved till false för att den ska behandlas som en osparad fil
            fileSaved = false;
        }
    }//GEN-LAST:event_menuInsertHTMLActionPerformed

    private void menuFileSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileSaveAsActionPerformed
        fileSaved = false;
        saveFile();
        fileSaved = true;
    }//GEN-LAST:event_menuFileSaveAsActionPerformed

    private void menuEditSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditSearchActionPerformed
        String searchString = JOptionPane.showInputDialog(this, "Search for:", "Search", -1);
        
        searchTextArea(this.jTextArea1, searchString);
    }//GEN-LAST:event_menuEditSearchActionPerformed

    private void menuEditClearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditClearSearchActionPerformed
        JTextComponent textComp = this.jTextArea1;
        removeHighlight(textComp);
    }//GEN-LAST:event_menuEditClearSearchActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TextEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TextEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TextEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TextEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TextEditorGUI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenuItem menuEditClearSearch;
    private javax.swing.JMenuItem menuEditCopy;
    private javax.swing.JMenuItem menuEditCut;
    private javax.swing.JMenuItem menuEditPaste;
    private javax.swing.JMenuItem menuEditSearch;
    private javax.swing.JMenuItem menuEditSelectAll;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuFileExit;
    private javax.swing.JMenuItem menuFileNew;
    private javax.swing.JMenuItem menuFileNewWindow;
    private javax.swing.JMenuItem menuFileOpen;
    private javax.swing.JMenuItem menuFileSave;
    private javax.swing.JMenuItem menuFileSaveAs;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuHelpAbout;
    private javax.swing.JMenu menuInsert;
    private javax.swing.JMenuItem menuInsertHTML;
    // End of variables declaration//GEN-END:variables

    
    public void setIcon(String file) {
        
        
        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(file)));
        } catch (Exception e) {
            //Om ikonen inte hittas. Kör utan
            System.out.println(e);
        }

    }
    
    public void startDemo() {
        
        //Sparar pågående text innan demot startar för att kunna återställa efteråt
        String saveArea = jTextArea1.getText();
        
        // Fade bakgrunden till grå
        for (int i = 255; i >= 50; i--) {
            jTextArea1.setBackground(new java.awt.Color(i, i, i));
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(TextEditorGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        //skapar String med logo
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        String charString = "\n" +
        "             	+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+                                     \n" +
        "             	| d | e | W | e |   | E | d | i | t | o | r |                                     \n" +
        "             	+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ \n";
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        //Sätter textfärg till grå
        jTextArea1.setForeground(new java.awt.Color(50, 50, 50));
        jTextArea1.setText(charString);
        //Fade textfärg grå till vit
        for (int i = 50; i <= 200; i = i + 2) {
            jTextArea1.setForeground(new java.awt.Color(i, i, i));
            
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(TextEditorGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Random rand = new Random();
        
        StringBuilder str = new StringBuilder();
        str.append(" deWe Editor\n"
                 + " Version 1.0.1\n"
                 + " © 2020 Daniel Wallgren\n"
                 + " All rights reserved\n"
                 + "\n\n"
                 + " deWe Editor is a simple text editor coded with Java + Swing.\n"
                 + " This editor was made for my own educational purposes\n"
                 + " and will most likely not get any further updates.\n"
                 + "\n"
                 + " Music: deWe - Grebykiosken 1996\n"
                 + "\n\n\n\n"
                 + " while(noSucess) {\n"
                 + "        tryAgain();\n"
                 + "        if(!noSucess) {\n"
                 + "                System.out.println(\"Long Live The Wild Ones!\")\n"
                 + "                break;\n"
                 + "        }\n"
                 + " }\n"
                 + "\n\n\n"
                 + "\n\n"
                 + "");
        
        
        //Ska göras till en metod kallad humanTyper
        for (int i = 0; i < str.length(); i++) {
            
            charString = charString + String.valueOf(str.charAt(i));
            jTextArea1.setText(charString);
            try {
                int rand1 = rand.nextInt(50)+50;
                long rand2 = rand1;
                
                Thread.sleep(rand2);
            } catch (InterruptedException ex) {
                Logger.getLogger(TextEditorGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Sleep innan count down
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(TextEditorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Text count-down
        for (int i = 4; i >= 0; i--) {
            
            this.jTextArea1.setText(charString + " (Returning in " + i + " seconds...)");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TextEditorGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        //Fade vit grå till grå
        for (int i = 200; i >= 50; i = i - 2) {
            jTextArea1.setForeground(new java.awt.Color(i, i, i));
            
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(TextEditorGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Sätter text från pågeående arbete innan bakgrunden fadar tillbaka
        jTextArea1.setText(saveArea);
        
        // Fade tillbaka bakgrunden till vit
        for (int i = 50; i <= 255; i++) {
            jTextArea1.setBackground(new java.awt.Color(i, i, i));
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(TextEditorGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        //thread.interrupt();
        //play.thread.stop();
        
    }
    
    public void openFile(){
        JFileChooser chooser = new JFileChooser();
        
        FileFilter filter = new FileNameExtensionFilter(".txt", "txt");
        // Lägger till filfiltret "filter" (.txt) som val i opendialogen
        chooser.addChoosableFileFilter(filter);
        // Sätter default filfilter till "filter" (.txt) i open dialogen
        chooser.setFileFilter(filter);
        
        //Öppnar opendialogen och sparar return i variabeln response
        int response = chooser.showOpenDialog(this);
        
        //Sparar filnamnet i variabeln fileName
        fileName = chooser.getSelectedFile().getName();
        //Om en fil väljs i dialogrutan
        if(response == JFileChooser.APPROVE_OPTION) {
            File file;
            file = chooser.getSelectedFile();
            savedFilePath = new File(chooser.getSelectedFile().getAbsolutePath()); 
            
            try {
                BufferedReader br = new BufferedReader(new FileReader(file.getPath()));

                String fileText = "";
                String line;

                while((line = br.readLine()) != null){
                        fileText = fileText + line + "\n";
                }
                br.close();
                jTextArea1.setText(fileText);
                // Sätter titel på programmet till aktuellt filnamn
                this.setTitle("deWe Editor -> " + fileName);
                //sätts till true eftersom aktuell fil nu finns sparad
                fileSaved = true;
                currentSavedFileContent = fileText;
                
            } catch (IOException e) {
                 JOptionPane.showMessageDialog(this, "File not found");
            }
        } 
    }
    
    public void saveFile(){
        //Om filen inte tidigare är sparad... (så ska dialograutan för att välja filnamn osv komma upp)
        if (fileSaved != true) {
            
            JFileChooser chooser = new JFileChooser();
            
            FileFilter filter = new FileNameExtensionFilter(".txt", "txt");
            // Lägger till filfiltret "filter" (.txt) som val i spardialogen
            chooser.addChoosableFileFilter(filter);
            // Sätter default filfilter till "filter" (.txt) i spardialogen
            chooser.setFileFilter(filter);
            //Öppnar savedialogen och sparar return i variabeln response
            int response = chooser.showSaveDialog(this);
            
            File file = null;
            if (response == JFileChooser.APPROVE_OPTION) {
                
                file = new File(chooser.getSelectedFile().getAbsolutePath()); 
            } 
            savedFilePath = file;
            
            //Om inte filändelsen slutar med valt filfilter...
            //endsWith returnerar
            if(!chooser.getSelectedFile().getAbsolutePath().endsWith(chooser.getFileFilter().getDescription())){
                //Om valt filfilter är *.* (All Files) så sätt default .txt som filändelse
                if (chooser.getFileFilter().getDescription().equals("All Files")) {
                    file = new File(chooser.getSelectedFile().getAbsolutePath() + ".txt");
                    savedFilePath = file;
                }
                // Annars sätt filändelse till valt filfilter
                else{
                    file = new File(chooser.getSelectedFile().getAbsolutePath() + chooser.getFileFilter().getDescription());
                    savedFilePath = file;
                }
                
            }
            //Sparar filnamnet i variabeln fileName
            fileName = chooser.getSelectedFile().getName();
            
        }
        // Om filen redan är sparad tidigare så skrivs filen över direkt, utan någon dialograuta.
        try {
            // Skapar FileWriter
            FileWriter file = new FileWriter(savedFilePath, false);
            //Skapar BufferedWriter med FileWriter
            BufferedWriter writer = new BufferedWriter(file);
            // Skriver filen
            writer.write(jTextArea1.getText());
            writer.close();
            file.close();
            
            fileSaved = true;
            currentSavedFileContent = jTextArea1.getText();
            
            this.setTitle("deWe Editor -> " + fileName);
            
        } 
        catch (IOException e) { 
            JOptionPane.showMessageDialog(this, e.getMessage()); 
        }
        
    }
    
    public void newWindow(){
        fileName = "New File";
        TextEditorGUI gui2 = new TextEditorGUI();
        
        int boundsX = getX();
        int boundsY = getY();
        
        gui2.setBounds( boundsX+30, boundsY+40, 450, 600);
        
        gui2.setResizable(false);
        gui2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gui2.setTitle("deWe Editor -> " + fileName);
        gui2.jTextArea1.setText("");
        gui2.setVisible(true);
        
        gui2.fileSaved = false;
        gui2.currentSavedFileContent = "";
    }
    
    public void newFile(){
        if(saveQuestion()){
            fileName = "New File";
            this.jTextArea1.setText("");
            this.setTitle("deWe Editor -> " + fileName);

            currentSavedFileContent = "";
            //Sätter fileSaved till false för att den ska behandlas som en osparad fil
            fileSaved = false;
        }
        
    }
    
    public void exitProgram(){
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        //Hämtar text i TextArea och sparar i strängen textField
        String textField = this.jTextArea1.getText();
        //Om textField innehåller samma som senast sparade fil (Även ny tom fil).
        if (textField.equals(currentSavedFileContent)){
                dispose();
        }
        //Om textField innehåller ny data så kommer dialogruta om att spara
        else{
            int save = JOptionPane.showConfirmDialog(this, "Save changes for \"" + fileName + "\" before exit?", "Save?",
            JOptionPane.YES_NO_CANCEL_OPTION);
            
            if (save == JOptionPane.YES_OPTION) {
                saveFile();
                dispose();
            }
            else if (save == JOptionPane.NO_OPTION) {
                dispose();
                
            }
            else if (save == JOptionPane.CANCEL_OPTION){
                //Gör ingenting (återgår till programmet istället för att avsluta)
            }
        }
    }
    
    public void removeHighlight(JTextComponent textComp){
        Highlighter removeHighlighter = textComp.getHighlighter();
        Highlighter.Highlight[] remove = removeHighlighter.getHighlights();
        
        
        
        for (int i = 0; i < remove.length; i++) {
            if(remove[i].getPainter() instanceof myHighlighter){
                removeHighlighter.removeHighlight(remove[i]);
        }
            
        }
    }
    
    
    public void searchTextArea(JTextComponent textComp, String textString){
        //Tar bort senaste highlighten
        removeHighlight(textComp);
        //If-sats som förhindrar att programmet fastnar i en oändlig
        //while-loop om användaren söker efter en tom sträng.
        if(!textString.equals("")){
        
            DefaultHighlighter.DefaultHighlightPainter highlighter = new myHighlighter(Color.yellow);

            try {
                Highlighter highlight = textComp.getHighlighter();
                // Kan fördmoligen göras genom att bara köra String text = jTextArea1.getText() istället
                Document doc = textComp.getDocument();
                String text = doc.getText(0, doc.getLength());
                

                int pos = 0;

                while((pos = text.toUpperCase().indexOf(textString.toUpperCase(), pos)) >= 0){
                    highlight.addHighlight(pos, pos+textString.length(), highlighter);
                    pos += textString.length();
                    

                }
            } catch (Exception e) {
            }
        }
    }
    
    public void playSound(String file) {
        play = new MakeSound();
        play.playSound(file);
        
        
    }

    @Override
    public void run() {
        startDemo();
    }
    
    public boolean saveQuestion(){
        boolean isDone = false;
        String textField = this.jTextArea1.getText();
        //Om textField innehåller samma som senast sparade fil (Även ny tom fil).
        if (textField.equals(currentSavedFileContent)){
            //isDone sätts till true för att returnera att kontrollen är utförd
            isDone = true;
        }
        //Om textField innehåller ny data så kommer dialogruta om att spara
        else{
            int save = JOptionPane.showConfirmDialog(this, "Save changes for \"" + fileName + "\"?", "Save?",
            JOptionPane.YES_NO_CANCEL_OPTION);
            
            if (save == JOptionPane.YES_OPTION) {
                saveFile();
                //isDone sätts till true för att returnera att kontrollen är utförd
                isDone = true;
            }
            else if (save == JOptionPane.NO_OPTION) {
                //isDone sätts till true för att returnera att kontrollen är utförd
                isDone = true;
            }
            else if (save == JOptionPane.CANCEL_OPTION){
                //isDone sätts till false för att returnera att användaren avbröt dialogrutan
                //och har ångrat sig.
                isDone = false;
            }
        }
        
        return isDone;
    }


}
