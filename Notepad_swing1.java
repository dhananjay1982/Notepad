import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
public class Notepad_swing1 extends JFrame implements ActionListener
{
	Frame frm;
    JMenuBar mnubr;
    JMenu fileMenu, editMenu, FormatMenu,viewMenu,HelpMenu;
    JMenuItem newitem,openitem,saveitem,save_asitem,exititem;
    //FileDialog fd;
    JTextArea ta;
    Font ft;
    JFileChooser fd;
    JScrollPane jsp;
    Notepad_swing1()
    {
	ta=new JTextArea();
	jsp=new JScrollPane(ta);
	add(jsp);

	ft=new Font("verdana",3,30);
	ta.setFont(ft);

    mnubr = new JMenuBar();
    fileMenu = new JMenu("File");
    editMenu = new JMenu("Edit");
    FormatMenu = new JMenu("Format");
	viewMenu = new JMenu("view");
    HelpMenu = new JMenu("Help");

    mnubr.add(fileMenu);
    mnubr.add(editMenu);
    mnubr.add(FormatMenu);
    mnubr.add(viewMenu);
    mnubr.add(HelpMenu);

    newitem = new JMenuItem("New");
    openitem = new JMenuItem("Open");
    saveitem = new JMenuItem("Save");
    save_asitem = new JMenuItem("Save_as");
    exititem = new JMenuItem("Exit");

    fileMenu.add(newitem);
     fileMenu.addSeparator();
    fileMenu.add(openitem);
     fileMenu.addSeparator();
    fileMenu.add(saveitem);
     fileMenu.addSeparator();
    fileMenu.add(save_asitem);
    fileMenu.addSeparator();
    fileMenu.add(exititem);

    setTitle("Notepad");
    setBounds(200,200,500,400);
    setVisible(true);
    setExtendedState(MAXIMIZED_BOTH);
    setJMenuBar(mnubr);
    newitem.addActionListener(this);
    openitem.addActionListener(this);
    saveitem.addActionListener(this);
    save_asitem.addActionListener(this);
    exititem.addActionListener(this);

   // fd=new FileDialog(this);

}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==newitem)
	{
		ta.setText("");
		ta.requestFocus();
	}
	if(e.getSource()==exititem)
	{
		System.exit(0);
	}
	if(e.getSource()==openitem)
	{
		fd=new JFileChooser();
		fd.showOpenDialog(this);
		try
	      {
				   FileReader fr=new FileReader(fd.getSelectedFile());
				   BufferedReader br = new BufferedReader(fr);
				   String data = "";
				   while((data = br.readLine())!=null)
				   {
					   ta.append(data+"\n");
				   }
				   fr.close();
			   }
			   catch(Exception we)
			   {
				   we.printStackTrace();
	   }
	   ta.requestFocus();
	}
	if(e.getSource()==saveitem)
	{
	    fd=new JFileChooser();
        fd.showSaveDialog(this);
	   try
	   {
		   FileWriter fr = new FileWriter(fd.getSelectedFile());
		   String data = ta.getText();
		   data=data+"\n";
		   fr.write(data);
		   fr.close();
	   }
	   catch(Exception we)
	   {
		   we.printStackTrace();
	   }
	}
}
public static void main(String[] args)
{
    new Notepad_swing1();
}
}