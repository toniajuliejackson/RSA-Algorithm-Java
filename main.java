package Gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Gui extends JFrame {

	private static final long serialVersionUID = -2015036022929739032L;

	/*
	 * Constructor
	 */
	public Gui() {
		getContentPane().setBackground(Color.WHITE);
		initComponents();
	}

	/*
	 * Variable declaration
	 */
	static JButton createKeys, encryptBtn, decryptBtn, clearKeys, saveKeys, loadKeys;
	static JPanel keys,encryptOrDecrypt, encryptOrDecryptBtns;
	private JLabel largePrimeP_label, largePrimeQ_label, PublicKey_label, PrivateKey_label, RandomKey_label;
	private JTextField largePrimeP_Field, largePrimeQ_Field, PublicKey_Field, PrivateKey_Field, RandomKey_Field;
	private JTextArea textAreaEncryptOrDecrypt;
	static JScrollPane scrollPaneInput;
	private JPanel panel;
	private JTextArea textAreaOutputEncrypt;
	private JPanel panel_1;
	private JTextArea textAreaOutputDecrypt;

	/*
	 * Set up of components
	 */
	private void initComponents() {

		createKeys = new JButton();
		encryptBtn = new JButton();
		decryptBtn = new JButton();

		encryptOrDecryptBtns = new JPanel();
		encryptOrDecryptBtns.setBackground(Color.WHITE);

		largePrimeP_label = new JLabel();
		PublicKey_label = new JLabel();
		RandomKey_label = new JLabel();
		PrivateKey_label = new JLabel();
		largePrimeQ_label = new JLabel();

		largePrimeP_Field = new JTextField();
		largePrimeQ_Field = new JTextField();
		RandomKey_Field = new JTextField();
		PublicKey_Field = new JTextField();
		PrivateKey_Field = new JTextField();
		textAreaEncryptOrDecrypt = new JTextArea();
		textAreaEncryptOrDecrypt.setWrapStyleWord(true);
		textAreaEncryptOrDecrypt.setLineWrap(true);
		textAreaEncryptOrDecrypt.setBackground(Color.WHITE);
		scrollPaneInput = new JScrollPane();

		/*
		 * Container 
		 * @Title 'RSA _ Security Assignment'
		 * Try to load the icon image
		 * Catch will run it as a jar
		 */
		setTitle("RSA _ Security Assignment");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);
		try { 
			ClassLoader cl = this.getClass().getClassLoader();
			setIconImage(new ImageIcon(cl.getResource("images/icon.jpg")).getImage());
		}
		catch (Exception e) {
		}

		Container contentPane = getContentPane();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
		contentPane.setLayout(gridBagLayout);
		((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {10, 636, 10};
		((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {3, 0, 10, 192, 10, 100, 10, 0, 19, 100, 100, 0, -31, 0};
		((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 1.0E-4};

		/*
		 * Declaration of the Grid Bag Layout for the window
		 */
		GridBagLayout gbl_keys = new GridBagLayout();
		gbl_keys.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_keys.columnWidths = new int[]{0, 0, 0, 152, 0, 0, 133};
		keys = new JPanel(gbl_keys);
		keys.setBackground(Color.WHITE);
		((GridBagLayout)keys.getLayout()).columnWidths = new int[] {25, 162, 32, 105, 110, 105, 105, 20, 0};
		((GridBagLayout)keys.getLayout()).rowHeights = new int[] {12, 0, 0, 0, 0, 0, 5, 0};
		((GridBagLayout)keys.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0E-4};
		((GridBagLayout)keys.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

		keys.setBorder(new TitledBorder(new LineBorder(Color.gray, 1, true), "Key creation"));

		/*
		 * 'Large Prime P' initailising and placement
		 */
		largePrimeP_label.setText("Large Prime 1");
		largePrimeP_label.setHorizontalAlignment(SwingConstants.CENTER);
		keys.add(largePrimeP_label, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));
		largePrimeP_Field.setEditable(false);
		keys.add(largePrimeP_Field, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		/*
		 *  'Public Key' initailising and placement 
		 */
		PublicKey_label.setText("Public Key");
		PublicKey_label.setHorizontalAlignment(SwingConstants.CENTER);
		keys.add(PublicKey_label, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));
		PublicKey_Field.setEditable(false);
		keys.add(PublicKey_Field, new GridBagConstraints(3, 1, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

		/*
		 * 'Large Prime Q' initailising and placement
		 */
		largePrimeQ_label.setText("Large Prime 2");
		largePrimeQ_label.setHorizontalAlignment(SwingConstants.CENTER);
		keys.add(largePrimeQ_label, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));
		largePrimeQ_Field.setEditable(false);
		keys.add(largePrimeQ_Field, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		/*
		 *  'Private Key' initailising and placement
		 */
		PrivateKey_label.setText("Private Key");
		PrivateKey_label.setHorizontalAlignment(SwingConstants.CENTER);
		keys.add(PrivateKey_label, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));
		PrivateKey_Field.setEditable(false);
		keys.add(PrivateKey_Field, new GridBagConstraints(3, 2, 4, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

		/*
		 * 'Random Key' initailising and placement
		 */
		RandomKey_label.setText("Random Key");
		RandomKey_label.setHorizontalAlignment(SwingConstants.CENTER);
		keys.add(RandomKey_label, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));
		RandomKey_Field.setEditable(false);
		keys.add(RandomKey_Field, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));
		loadKeys = new JButton();

		/*
		 * 'Load Keys' button with action performed	
		 */
		loadKeys.setText("Load keys");
		loadKeys.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadKeysButtonActionPerformed(e);
			}
		});

		keys.add(loadKeys, new GridBagConstraints(6, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));;

		/*
		 * 'Create Keys' button with action performed
		 */
		createKeys.setText("Create keys");
		createKeys.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createKeysButtonActionPerformed(e);
			}
		});

		keys.add(createKeys, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,	new Insets(0, 0, 0, 5), 0, 0));;
		contentPane.add(keys, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 5, 5), 0, 0));
		saveKeys = new JButton();

		/*
		 * 'Save Keys' button with action performed	
		 */
		saveKeys.setText("Save keys");
		saveKeys.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveKeysButtonActionPerformed(e);
			}
		});
		clearKeys = new JButton();
		/*
		 * 'Clear Keys' button with action performed
		 */
		clearKeys.setText("Clear keys");
		clearKeys.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearKeysButtonActionPerformed(e);
			}
		});

		keys.add(clearKeys, new GridBagConstraints(5, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,	new Insets(0, 0, 0, 5), 0, 0));

		keys.add(saveKeys, new GridBagConstraints(6, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		/*
		 * 'Message to Encrypt or Decrypt' textarea
		 */
		encryptOrDecrypt =  new JPanel(new GridBagLayout());
		encryptOrDecrypt.setBackground(Color.WHITE);
		((GridBagLayout)encryptOrDecrypt.getLayout()).columnWidths = new int[] {10, 435, 5, 0};
		((GridBagLayout)encryptOrDecrypt.getLayout()).rowHeights = new int[] {71, 5, 0};
		((GridBagLayout)encryptOrDecrypt.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
		((GridBagLayout)encryptOrDecrypt.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

		encryptOrDecrypt.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "Message to encrypt/decrypt", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPaneInput.setViewportView(textAreaEncryptOrDecrypt); 
		encryptOrDecrypt.add(scrollPaneInput, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

		contentPane.add(encryptOrDecrypt, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

		/*
		 * Placement of 'encrypt' and 'decrypt' buttons in the GridBagLayout
		 */
		encryptOrDecryptBtns.setLayout(new GridBagLayout());
		((GridBagLayout)encryptOrDecryptBtns.getLayout()).columnWidths = new int[] {155, 105, 20, 105, 150, 0};
		((GridBagLayout)encryptOrDecryptBtns.getLayout()).rowHeights = new int[] {28, 0};
		((GridBagLayout)encryptOrDecryptBtns.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4};
		((GridBagLayout)encryptOrDecryptBtns.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

		/*
		 * 'Encrypt' Button and action performed 
		 */
		encryptBtn.setText("Encrypt");
		encryptBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				encryptButtonActionPerformed(e);
			}
		});

		encryptOrDecryptBtns.add(encryptBtn, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 0, 0));

		/*
		 * 'Decrypt' button action performed
		 */
		decryptBtn.setText("Decrypt");
		decryptBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				decryptButtonActionPerformed(e);
			}
		});

		encryptOrDecryptBtns.add(decryptBtn, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 0, 0));
		contentPane.add(encryptOrDecryptBtns, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Encrypted Message", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 9;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWeights = new double[]{1.0};
		gbl_panel.rowWeights = new double[]{0.0, 1.0};
		panel.setLayout(gbl_panel);

		textAreaOutputEncrypt = new JTextArea();
		textAreaOutputEncrypt.setWrapStyleWord(true);
		textAreaOutputEncrypt.setLineWrap(true);
		textAreaOutputEncrypt.setBackground(Color.WHITE);
		GridBagConstraints gbc_textAreaOutputEncrypt = new GridBagConstraints();
		gbc_textAreaOutputEncrypt.insets = new Insets(0, 0, 0, 5);
		gbc_textAreaOutputEncrypt.fill = GridBagConstraints.BOTH;
		gbc_textAreaOutputEncrypt.gridx = 0;
		gbc_textAreaOutputEncrypt.gridy = 1;
		panel.add(textAreaOutputEncrypt, gbc_textAreaOutputEncrypt);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Decrypted Message", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 10;
		getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWeights = new double[]{1.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0};
		panel_1.setLayout(gbl_panel_1);

		textAreaOutputDecrypt = new JTextArea();
		textAreaOutputDecrypt.setWrapStyleWord(true);
		textAreaOutputDecrypt.setLineWrap(true);
		textAreaOutputDecrypt.setBackground(Color.WHITE);
		GridBagConstraints gbc_textAreaOutputDecrypt = new GridBagConstraints();
		gbc_textAreaOutputDecrypt.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaOutputDecrypt.fill = GridBagConstraints.BOTH;
		gbc_textAreaOutputDecrypt.gridx = 0;
		gbc_textAreaOutputDecrypt.gridy = 1;
		panel_1.add(textAreaOutputDecrypt, gbc_textAreaOutputDecrypt);


		setSize(750, 675);
		setLocationRelativeTo(null);
		toFront();
		setVisible(true);
	}

	/**
	 * 'Encrypt' button pressed.
	 */
	private void encryptButtonActionPerformed(ActionEvent e) {
		String message = textAreaEncryptOrDecrypt.getText();
		byte[] msg = message.getBytes();
		byte[] cipher = encrypt(msg);
		String cipherTxt = new String(cipher);
		textAreaOutputEncrypt.setText(cipherTxt);
	}

	/**
	 * 'Decrypt' button pressed.
	 */
	private void decryptButtonActionPerformed(ActionEvent e) {
		String message = textAreaEncryptOrDecrypt.getText();
		byte[] msg = message.getBytes();
		byte[] encrypt = encrypt(msg);
		byte[] plain = decrypt(encrypt);
		String plainTxt = new String(plain);
		textAreaOutputDecrypt.setText(plainTxt);
	}

	/**
	 * 'Create keys' button pressed.
	 * @param e
	 */
	private void createKeysButtonActionPerformed(ActionEvent e) {
		createKeys();
	}

	/**
	 * 'Save keys' button pressed.
	 * @param e
	 */
	private void saveKeysButtonActionPerformed(ActionEvent e) {
		saveKeys();
	}

	/**
	 * 'Load keys' button pressed.
	 * @param e
	 */
	private void loadKeysButtonActionPerformed(ActionEvent e) {
		loadKeys();
	}

	/**
	 * 'Clear keys' button pressed.
	 * @param e
	 */
	private void clearKeysButtonActionPerformed(ActionEvent e) {
		clearKeyTextFields();
	}

	/**
	 * Clears textfield containing key info.
	 */
	private void clearKeyTextFields() {
		int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to clear the fields", "Clear", JOptionPane.YES_NO_CANCEL_OPTION);

		if (response == JOptionPane.YES_OPTION) {
			largePrimeP_Field.setText("");
			largePrimeQ_Field.setText("");
			RandomKey_Field.setText("");
			PublicKey_Field.setText("");
			PrivateKey_Field.setText("");
		} 
	}

	/**
	 * Generates keys.
	 */
	private void createKeys() {
		BigInteger largePrimeP, largePrimeQ;			// large prime numbers p and q.
		BigInteger modulusN;							// Modulus N
		BigInteger R; 									// r = ( p - 1 ) * ( q - 1 )
		BigInteger E, D = BigInteger.valueOf(24613); 	// Public E and Private D

		Random rand = new Random(System.currentTimeMillis()/2);
		Random rand1 = new Random(System.currentTimeMillis());
		Random rand2 = new Random(System.currentTimeMillis()*10);

		/**
		 * Big Integer is used to randomly generate positive number that is probably prime
		 */
		largePrimeP = BigInteger.probablePrime(1024, rand1);
		largePrimeQ = BigInteger.probablePrime(1024, rand2);
		R = largePrimeP.subtract(BigInteger.valueOf(1)).multiply(largePrimeQ.subtract(BigInteger.valueOf(1)));
		E = BigInteger.probablePrime(1024, rand);
		D = E.modInverse(R);
		modulusN = largePrimeP.multiply(largePrimeQ);
		System.out.println(modulusN);

		while (true){
			//BigInteger GCD = R.gcd(new BigInteger(""+E));
			BigInteger GCD = findGCD(R, E);
			if (GCD.equals(BigInteger.ONE)){ 
				break;
			}
			E.add(BigInteger.valueOf(1));
		}

		largePrimeP_Field.setText(largePrimeP.toString());
		largePrimeQ_Field.setText(largePrimeQ.toString());
		RandomKey_Field.setText(E.toString());
		PublicKey_Field.setText(modulusN.toString());
		PrivateKey_Field.setText(D.toString());
	}

	/**
	 * GCD
	 * @return 
	 */
	private BigInteger findGCD(BigInteger number1, BigInteger number2) {
		//base case
		if(number2 == BigInteger.valueOf(0)){
			return number1;
		}
		return findGCD(number2, number1.mod(number2));
	}
	
	/**
	 * ModPower of msg, exponent and modulus
	 * @param m the value of message byte
	 * @param exp the power
	 * @param n the modulus
	 * @return m<sup>exp</sup> mod n
	 */
	protected static BigInteger modPower (BigInteger msg, BigInteger exponent, BigInteger n) {
		BigInteger value = BigInteger.ONE;
		//Keeps going as long as the exponent is negative
		while (exponent.signum ( ) > 0) {
			//test bit will be true if it is set
			if (exponent.testBit (0)) {
				value = value.multiply(msg).mod(n);
			}
			exponent = exponent.shiftRight(1);
			msg = msg.multiply(msg).mod(n);
		}
		return value;
	}

	/**
	 * Save keys to a file.
	 */
	private void saveKeys() {
		try {
			int response = JOptionPane.showConfirmDialog(null, "Keys are saved to file", "Saved", JOptionPane.OK_CANCEL_OPTION);
			if (response == JOptionPane.OK_OPTION) {
				File myFile = new File("RSAKeys.txt");          
				FileOutputStream outFileStream;
				outFileStream = new FileOutputStream(myFile);
				PrintWriter outStream = new PrintWriter(outFileStream);
				outStream.println(largePrimeP_Field.getText());
				outStream.println(largePrimeQ_Field.getText());
				outStream.println(PublicKey_Field.getText());
				outStream.println(PrivateKey_Field.getText());
				outStream.println(RandomKey_Field.getText());
				outStream.close();
			} 
		} 
		catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Load keys to a file.
	 */
	private void loadKeys() {
		try {   
			FileReader fileReader = new FileReader("RSAKeys.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			List ArrayKeys = new List();
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				ArrayKeys.add(line);
			}

			bufferedReader.close();

			largePrimeP_Field.setText(ArrayKeys.getItem(0));
			largePrimeQ_Field.setText(ArrayKeys.getItem(1));
			PublicKey_Field.setText(ArrayKeys.getItem(2));
			PrivateKey_Field.setText(ArrayKeys.getItem(3));
			RandomKey_Field.setText(ArrayKeys.getItem(4));
		} 
		catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Encrypts the text written in 'Message to encrypt/decrypt' textarea.
	 * @return 
	 */
	public byte[] encrypt(byte[] message) {
		BigInteger rand = new BigInteger(RandomKey_Field.getText()); 
		BigInteger Public = new BigInteger(PublicKey_Field.getText());
		System.out.println(new BigInteger(message));
		return modPower(new BigInteger(message), rand, Public).toByteArray();
	}

	/**
	 * Decrypts the text written in 'Message to encrypt/decrypt' textarea.
	 * @return 
	 */
	public byte[] decrypt(byte[] message) {
		BigInteger Private = new BigInteger(PrivateKey_Field.getText()); 
		BigInteger Public = new BigInteger(PublicKey_Field.getText());
		return modPower(new BigInteger(message), Private, Public).toByteArray();
	}

	/**
	 * Executes GUI in a thread.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() { 
			@Override
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(false);
				new Gui();
			}
		});
	}

}
