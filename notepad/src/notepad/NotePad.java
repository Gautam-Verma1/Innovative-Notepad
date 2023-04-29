package notepad;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class Myframe01 extends Frame{
    MenuBar bar;
    Menu menu1,menu2,format_menu,font_size,theme;
    MenuItem new_item1,item2,item3,item4,item5,item6,item7,item8;
    MenuItem dracula,queen,dawn,light;
    MenuItem size_8,size_12,size_16,size_20,size_24,size_28;
    TextArea textArea;
    String text;

    Myframe01(){
        setTitle("Untitled - CodePad");

        MenuShortcut
                menuShortcut_new_item1 = new
                MenuShortcut(KeyEvent.VK_N);
        MenuShortcut
                menuShortcut_item2 = new
                MenuShortcut(KeyEvent.VK_O);
        MenuShortcut
                menuShortcut_item3 = new
                MenuShortcut(KeyEvent.VK_S);
        MenuShortcut
                menuShortcut_item4 = new
                MenuShortcut(KeyEvent.VK_X);
        MenuShortcut
                menuShortcut_item5 = new
                MenuShortcut(KeyEvent.VK_C);
        MenuShortcut
                menuShortcut_item6 = new
                MenuShortcut(KeyEvent.VK_V);
        MenuShortcut
                menuShortcut_item7 = new
                MenuShortcut(KeyEvent.VK_T);
        MenuShortcut
                menuShortcut_item8 = new
                MenuShortcut(KeyEvent.VK_A);
        bar = new MenuBar();
        menu1 = new Menu("File");
        menu2 = new Menu("Edit");

        format_menu=new
                Menu("Format");
        font_size=new Menu("Font Size");
                theme = new Menu("Theme");

        new_item1 =new
                MenuItem("New",menuShortcut_new_item1);
        item2 =new
                MenuItem("Open",menuShortcut_item2);
        item3 =new
                MenuItem("Save",menuShortcut_item3);
        item4 =new
                MenuItem("Exit",menuShortcut_item4);
        item5 =new
                MenuItem("Copy",menuShortcut_item5);
        item6 =new
                MenuItem("Paste",menuShortcut_item6);
        item7 =new
                MenuItem("Cut",menuShortcut_item7);
        item8 =new MenuItem("Select All",menuShortcut_item8);
                size_8 =new MenuItem("8");
        size_12 =new MenuItem("12");
        size_16 =new MenuItem("16");
        size_20=new MenuItem("20");
        size_24=new MenuItem("24");
        size_28=new MenuItem("28");
        dracula=new
                MenuItem("Dracula");
        queen=new MenuItem("Queen");
        dawn=new MenuItem("Dawn");
        light=new MenuItem("Light");
        menu1.add(new_item1);
        menu1.add(item2);
        menu1.add(item3);
        menu1.add(item4);

        menu2.add(item5);
        menu2.add(item6);
        menu2.add(item7);
        menu2.add(item8);

        format_menu.add(font_size);
        font_size.add(size_8);
        font_size.add(size_12);
        font_size.add(size_16);
        font_size.add(size_20);
        font_size.add(size_24);
        font_size.add(size_28);
        theme.add(dracula);
        theme.add(queen);
        theme.add(dawn);
        theme.add(light);

        textArea= new TextArea();

        bar.add(menu1);
        bar.add(menu2);
        bar.add(format_menu);
        bar.add(theme);
        setMenuBar(bar);
        add(textArea);
        Color dracula_Color = new
                Color(39,40,34);
        Color green_Color = new
                Color(166,226,41);
        Color orange_Color = new
                Color(219,84,34);
        Color queen_Color = new
                Color(174,129,219);


        textArea.setForeground(Color.BLUE);
        textArea.setFont(new
                Font(Font.MONOSPACED, Font.BOLD, 15));

        setSize(1000,600);
        setLocationRelativeTo(null);
        setVisible(true);

        textArea.addMouseListener(new MouseListener() {
                                              @Override
                                              public void
                                              mouseClicked(MouseEvent e) {
                                                  String s = "cmd open calc";

                                                  if(textArea.getText().equals(s)) {
                                                      MyCalculator m =
                                                              new MyCalculator();
                                                      m.setTitle("My Calculator");
                                                              m.setSize(250,300);
                                                      m.setVisible(true);
                                                  }
                                              }
                                              @Override
                                              public void
                                              mousePressed(MouseEvent e) {}
                                              @Override
                                              public void
                                              mouseReleased(MouseEvent e) {}
                                              @Override
                                              public void
                                              mouseEntered(MouseEvent e) {}
                                              @Override
                                              public void
                                              mouseExited(MouseEvent e) {}
                                          });

        item2.addActionListener(new ActionListener(){
                                            public void
                                            actionPerformed(ActionEvent event){
                                                FileDialog dialog = new
                                                        FileDialog(new
                                                        Frame(),"Open",FileDialog.LOAD); //this will load the fileDialog

                                                dialog.setVisible(true);//this will make dialog visible
                                                String path =
                                                        dialog.getDirectory()+dialog.getFile(); //this will select the path of selected file and put it into 'path'

                                                setTitle(dialog.getFile()+" - CodePad");//this will set Title to selected file name and -CodePad

                                                try {
                                                    FileInputStream fi =
                                                            new FileInputStream(path);
                                                    byte b[]=new
                                                            byte[fi.available()];
                                                    fi.read(b);
                                                    String str = new
                                                            String(b); //this will store b in str

                                                    textArea.setText(str);//this will display text in 'str' in textarea
                                                    fi.close();//this will close fi

                                                } catch (Exception e) {


                                                    System.out.println("Something went Wrong!");
                                                }
                                            }
                                        });
        new_item1.addActionListener(new ActionListener(){
                                                public void
                                                actionPerformed(ActionEvent event) {
                                                    setTitle("Untitled - CodePad");
                                                            textArea.setText(" ");
                                                }
                                            });
        item3.addActionListener(new ActionListener(){
                                            public void
                                            actionPerformed(ActionEvent event){
                                                FileDialog dialog = new
                                                        FileDialog(new Frame(),"Save ",FileDialog.SAVE);
                                                        dialog.setVisible(true);
                                                String path =
                                                        dialog.getDirectory()+dialog.getFile();

                                                setTitle(dialog.getFile()+"- CodePad");

                                                try {
                                                    FileWriter fw = new
                                                            FileWriter(path);

                                                    fw.write(textArea.getText());
                                                    fw.close();


                                                } catch (Exception e) {


                                                    System.out.println("Something went Wrong:(");
                                                }
                                            }
                                        });
        item4.addActionListener(new ActionListener(){
                                            public void
                                            actionPerformed(ActionEvent event){
                                                System.exit(0);
                                            }
                                        });
        item5.addActionListener(new ActionListener(){
                                            public void
                                            actionPerformed(ActionEvent event){
                                                text =
                                                        textArea.getSelectedText();
                                            }
                                        });
        item6.addActionListener(new ActionListener(){
                                            public void
                                            actionPerformed(ActionEvent event){

                                                textArea.insert(text,textArea.getCaretPosition());
                                            }
                                        });
        item7.addActionListener(new ActionListener(){
                                            public void
                                            actionPerformed(ActionEvent event){
                                                text =
                                                        textArea.getSelectedText();
                                                textArea.replaceRange("",
                                                        textArea.getSelectionStart(),
                                                        textArea.getSelectionEnd());
                                            }
                                        });

        item8.addActionListener(new ActionListener(){
                                            public void
                                            actionPerformed(ActionEvent event){
                                                textArea.selectAll();
                                            }
                                        });
        size_8.addActionListener(new ActionListener(){
                                             public void
                                             actionPerformed(ActionEvent event){
                                                 textArea.setFont(new
                                                         Font(Font.MONOSPACED, Font.BOLD,8));
                                             }
                                         });
        size_12.addActionListener(new ActionListener(){
                                              public void
                                              actionPerformed(ActionEvent event){
                                                  textArea.setFont(new
                                                          Font(Font.MONOSPACED, Font.BOLD,12));
                                              }
                                          });
        size_16.addActionListener(new ActionListener(){
                                              public void
                                              actionPerformed(ActionEvent event){
                                                  textArea.setFont(new
                                                          Font(Font.MONOSPACED, Font.BOLD,16));
                                              }
                                          });
        size_20.addActionListener(new ActionListener(){
                                              public void
                                              actionPerformed(ActionEvent event){
                                                  textArea.setFont(new
                                                          Font(Font.MONOSPACED, Font.BOLD,20));
                                              }
                                          });
        size_24.addActionListener(new ActionListener(){
                                              public void
                                              actionPerformed(ActionEvent event){
                                                  textArea.setFont(new
                                                          Font(Font.MONOSPACED, Font.BOLD,24));
                                              }
                                          });
        size_28.addActionListener(new ActionListener(){
                                              public void
                                              actionPerformed(ActionEvent event){
                                                  textArea.setFont(new
                                                          Font(Font.MONOSPACED, Font.BOLD,28));
                                              }
                                          });
        dracula.addActionListener(new ActionListener(){
                                              public void
                                              actionPerformed(ActionEvent event){


                                                  textArea.setBackground(dracula_Color);

                                                  textArea.setForeground(green_Color);
                                              }
                                          });
        queen.addActionListener(new ActionListener(){
                                            public void
                                            actionPerformed(ActionEvent event){

                                                textArea.setBackground(dracula_Color);

                                                textArea.setForeground(queen_Color);
                                            }
                                        });
        dawn.addActionListener(new ActionListener(){
                                           public void
                                           actionPerformed(ActionEvent event){

                                               textArea.setBackground(Color.WHITE);

                                               textArea.setForeground(orange_Color);
                                           }
                                       });
        light.addActionListener(new ActionListener(){
                                            public void
                                            actionPerformed(ActionEvent event){

                                                textArea.setBackground(Color.WHITE);

                                                textArea.setForeground(Color.BLUE);
                                            }
                                        });

        addWindowListener(new WindowAdapter(){
                                      public void
                                      windowClosing(WindowEvent event){
                                          System.exit(0);
                                      }
                                  });
    }
}
class MyCalculator extends Frame
        implements ActionListener {
    TextField tfInput;
    Panel panel;
    String btnString[] = {"7", "8", "9",
            "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "C", "0", "=", "/"};
    Button btn[] = new Button[16];
    int num1 = 0, num2 = 0, result = 0;
    char op;
    public MyCalculator() {
        Font f = new Font("Cambria",
                Font.BOLD, 18);
        tfInput = new TextField(10);
        tfInput.setFont(f);
        panel = new Panel();
        add(tfInput, "North");
        add(panel, "Center");
        panel.setLayout(new GridLayout(4,
                4));
        for (int i = 0; i < 16; i++) {
            btn[i] = new
                    Button(btnString[i]);
            btn[i].setFont(f);

            btn[i].addActionListener(this);
            panel.add(btn[i]);
        }
        addWindowListener(new
                                  WindowAdapter() {
                                      public void
                                      windowClosing(WindowEvent we) {
                                          System.exit(0);
                                      }
                                  });
    }
    public void
    actionPerformed(ActionEvent ae) {
        String str =
                ae.getActionCommand();
        if (str.equals("+")) {
            op = '+';
            num1 =
                    Integer.parseInt(tfInput.getText());
            tfInput.setText("");
        } else if (str.equals("-")) {
            op = '-';
            num1 =
                    Integer.parseInt(tfInput.getText());
            tfInput.setText("");
        } else if (str.equals("*")) {
            op = '*';
            num1 =
                    Integer.parseInt(tfInput.getText());
            tfInput.setText("");
        } else if (str.equals("/")) {
            op = '/';
            num1 =
                    Integer.parseInt(tfInput.getText());
            tfInput.setText("");
        } else if (str.equals("=")) {
            num2 =
                    Integer.parseInt(tfInput.getText());
            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            tfInput.setText(result + "");
            result = 0;
        } else if (str.equals("C")) {
            tfInput.setText("");
            num1 = num2 = result = 0;
        } else {

            tfInput.setText(tfInput.getText() + str);
        }
    }
}
public class NotePad{
    public static void main(String[]
                                    args) {
        new Myframe01();
    }
}
