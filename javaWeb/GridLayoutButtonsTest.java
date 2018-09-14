package helloword;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GridLayoutButtonsTest extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private int qtButton = 0; 

    public static void main(String[] args) 
    {
        GridLayoutButtonsTest frame = new GridLayoutButtonsTest();
        frame.setVisible(true);
    }

    public GridLayoutButtonsTest() 
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JScrollPane scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension(500, 500));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 10, 10));
          
        Object[][] table= {
        		
        		{"1","luz","25","1,75"},
        		{"1","luz","25","1,75"},
        		{"2","luz","25","1,75"},
        		{"1","luz","25","1,75"},
        		{"2","luz","25","1,75"},
        		{"1","luz","25","1,75"},
        		{"2","luz","25","1,75"},
        		{"1","luz","25","1,75"},
        		{"2","luz","25","1,75"},
        		{"1","luz","25","1,75"},
        		{"2","luz","25","1,75"},
        		{"1","luz","25","1,75"},
        		{"2","luz","25","1,75"},
        		{"1","luz","25","1,75"},
        		{"2","luz","25","1,75"},
        		{"1","luz","25","1,75"},
        		{"2","luz","25","1,75"},
        		{"1","luz","25","1,75"},
        		{"2","luz","25","1,75"},
        		{"1","luz","25","1,75"},
        		{"2","luz","25","1,75"},
        		{"1","luz","25","1,75"},
        		{"2","luz","25","1,75"},
        		{"1","luz","25","1,75"},
        		{"2","luz","25","1,75"},
        		{"1","luz","25","1,75"},
        		{"2","luz","25","1,75"},
        		{"1","luz","25","1,75"},
        		{"2","luz","25","1,75"},
        		{"1","luz","25","1,75"},
        		{"2","luz","25","1,75"},
        		{"1","luz","25","1,75"},
        		{"2","luz","25","1,75"},
        		{"1","luz","25","1,75"},
        		{"2","luz","25","1,75"},
        		{"2","luz","25","1,75"},
        		{"3","luz","25","1,75"},
    
        };
        String [] colunas = {"1","2","3","4"};
    
      JTable tb =new JTable(table,colunas);
       
       // {
            panel.add(tb);
       // }
        scroll.setViewportView(panel);
    
        contentPane.add(scroll);
        pack();
    }

  }