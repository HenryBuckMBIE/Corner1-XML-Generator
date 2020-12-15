package c1xml;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class InputScreen {

		public JFrame frame;
		
		public static JTextField SenderSchemeID;
		public static JTextField SenderNZBN;
		public static JTextField SenderParticipantID;
		public static JTextField ReceiverSchemeID;
		public static JTextField ReceiverNZBN;
		public static JTextField ReceiverParticipantID;
		
		public static JTextField SupplierName;
		public static JTextField SupplierAddress1;
		public static JTextField SupplierAddress2;
		public static JTextField SupplierCity;
		public static JTextField SupplierPostcode;
		public static JTextField SupplierCountryCode;
		
		public static JTextField CustomerName;
		public static JTextField CustomerAddress1;
		public static JTextField CustomerAddress2;
		public static JTextField CustomerCity;
		public static JTextField CustomerPostcode;
		public static JTextField CustomerCountryCode;
		
		public static JTextField BuyerReference;
		public static JTextField POReference;
		public static JTextField TaxScheme;
		public static JTextField InvoiceLineChargeReason;
		
		public static JTextField GoodsDescription1;
		public static JTextField GoodsDescription2;
		public static JTextField GoodsDescription3;
		
		// Invoice Level Charge
		public static JTextField AllowanceChargeDescription;		
		public static JTextField InvoiceLevelAllowance;
		public static JTextField InvoiceLevelCharge;
		
		public static JTextField Quantity1;
		public static JTextField Quantity2;
		public static JTextField Quantity3;
		
		public static JTextField BaseAmount1;
		public static JTextField BaseAmount2;
		public static JTextField BaseAmount3;
		
		public static JTextField Discount1;
		public static JTextField Discount2;
		public static JTextField Discount3;
		
		public static JTextField LineCharge1;
		public static JTextField LineCharge2;
		public static JTextField LineCharge3;
		
		public static JTextField PriceAmount1;
		public static JTextField PriceAmount2;
		public static JTextField PriceAmount3;
		
		public static JTextField LineExtensionAmount1;
		public static JTextField LineExtensionAmount2;
		public static JTextField LineExtensionAmount3;
		public static JTextField LineExtensionAmountTotal;
		
		public static JTextField TaxableAmount;
		public static JTextField TaxAmount;
		public static JTextField TaxExclusiveAmount;
		public static JTextField TaxInclusiveAmount;
		
		public static JTextField AllowanceTotalAmount;
		public static JTextField ChargeTotalAmount;
		public static JTextField PayableAmount;

		public static String sMODE = "sPAYLOAD";
		public static String sCurrencyID = "NZD";
		public static String sTaxCategoryID = "S";
		public static String sPercent1 = "15";
		public static String sPercent2 = "15";
		public static String sPercent3 = "15";
		public static String sPercent4 = "15";  //Allowance tax rate

		public static String  sUnitCode = "C62";
		public static String  sAllowanceChargeReason = "Item Packaging";
		public static String sResponseCode = "AP";
		
		// Optional Fields
		public static JTextField InvoiceDueDate;
		public static JTextField SupplierTaxIdentifier;
		public static JTextField SupplierContactName;
		public static JTextField SupplierContactTelephone;
		public static JTextField SupplierContactEmail;
		//
		// Payment Means
		public static JTextField PaymentMeansName;
		public static JTextField PaymentMeansAccount;
		public static String  sPaymentMeansCode = "1";
		
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						InputScreen window = new InputScreen();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public InputScreen() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			// 10, 10 is top LH Corner, then width & height
			frame.setBounds(10, 10, 1200, 650);
			frame.setTitle("XML Generator - Henry Buck Open Source Software (HBOSS)");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			
			// ********************************************************//
			// *************   ALL LABELS HERE   **********************//
			// ********************************************************//
			
			// Combo Boxes to select Sender & Receiver
			JLabel lblAPNorth = new JLabel("SENDER (AP North)");
			lblAPNorth.setBounds(15, 15, 150, 15);
			frame.getContentPane().add(lblAPNorth);
					
			JLabel lblAPSouth = new JLabel("RECEIVER (AP South)");
			lblAPSouth.setBounds(400, 15, 150, 15);
			frame.getContentPane().add(lblAPSouth);
			
			// Set italic font for the Participant ID's
			Font font = new Font("Verdana", Font.ITALIC, 12);
			
			JLabel lblSenderParticipantID = new JLabel("Participant ID");
			lblSenderParticipantID.setBounds(15, 35, 150, 15);	
			lblSenderParticipantID.setFont(font);
			frame.getContentPane().add(lblSenderParticipantID);
				
			JLabel lblReceiverParticipantID = new JLabel("Participant ID");
			lblReceiverParticipantID.setFont(font);
			lblReceiverParticipantID.setBounds(400, 35, 150, 15);	
			frame.getContentPane().add(lblReceiverParticipantID);	
			         
			// Supplier labels adding 15 to 2nd each time
			JLabel lblSupplierName = new JLabel("Supplier Name");
			lblSupplierName.setBounds(15, 65, 150, 15);
			frame.getContentPane().add(lblSupplierName);
			
			JLabel lblSupplierAddress1 = new JLabel("Supplier Address1");
			lblSupplierAddress1.setBounds(15, 80, 150, 15);
			frame.getContentPane().add(lblSupplierAddress1);
			
			JLabel lblSupplierAddress2 = new JLabel("Supplier Address2");
			lblSupplierAddress2.setBounds(15, 95, 150, 15);
			frame.getContentPane().add(lblSupplierAddress2);
			
			JLabel lblSupplierCity = new JLabel("City");
			lblSupplierCity.setBounds(70, 110, 150, 15);
			frame.getContentPane().add(lblSupplierCity);
			
			JLabel lblSupplierPostcode = new JLabel("Postcode");
			lblSupplierPostcode.setBounds(70, 125, 150, 15);
			frame.getContentPane().add(lblSupplierPostcode);
			
			JLabel lblSupplierCountry = new JLabel("Country Code");
			lblSupplierCountry.setBounds(70, 140, 150, 15);
			frame.getContentPane().add(lblSupplierCountry);
			
			// Customer labels adding 15 to 2nd each time
			JLabel lblCustomerName = new JLabel("Customer Name");
			lblCustomerName.setBounds(400, 65, 150, 15);
			frame.getContentPane().add(lblCustomerName);
					
			JLabel lblCustomerAddress1 = new JLabel("Customer Address1");
			lblCustomerAddress1.setBounds(400, 80, 150, 15);
			frame.getContentPane().add(lblCustomerAddress1);
					
			JLabel lblCustomerAddress2 = new JLabel("Customer Address2");
			lblCustomerAddress2.setBounds(400, 95, 150, 15);
			frame.getContentPane().add(lblCustomerAddress2);
					
			JLabel lblCustomerCity = new JLabel("City");
			lblCustomerCity.setBounds(470, 110, 150, 15);
			frame.getContentPane().add(lblCustomerCity);
					
			JLabel lblCustomerPostcode = new JLabel("Postcode");
			lblCustomerPostcode.setBounds(470, 125, 150, 15);
			frame.getContentPane().add(lblCustomerPostcode);
			
			JLabel lblCustomerCountry = new JLabel("Country Code");
			lblCustomerCountry.setBounds(470, 140, 150, 15);
			frame.getContentPane().add(lblCustomerCountry);
			
			// Buyer Reference or Purchase Order Reference is Mandatory
			JLabel lblBuyerReference = new JLabel("Buyer Reference");
			lblBuyerReference.setBounds(825, 15, 150, 15);
			frame.getContentPane().add(lblBuyerReference);
			JLabel lblPOReference = new JLabel("Purchase Order Ref");
			lblPOReference.setBounds(825, 30, 150, 15);
			frame.getContentPane().add(lblPOReference);
			
			// Tax Scheme
			JLabel lblTaxScheme = new JLabel("Tax Scheme");
			lblTaxScheme.setBounds(825, 50, 150, 15);
			frame.getContentPane().add(lblTaxScheme);
			
			// Unit Code (Required)
			JLabel lblUnitCode = new JLabel("Unit Code");
			lblUnitCode.setBounds(825, 70, 150, 15);
			frame.getContentPane().add(lblUnitCode);	
			
			// Allowance/Charge reason (or Code) - Required
			JLabel lblAllowanceChargeReason = new JLabel("Line Level Allowance");
			lblAllowanceChargeReason.setBounds(825, 90, 150, 15);
			frame.getContentPane().add(lblAllowanceChargeReason);
			JLabel lblAllowanceChargeReason2 = new JLabel("/Charge Reason");
			lblAllowanceChargeReason2.setBounds(825, 100, 150, 15);
			frame.getContentPane().add(lblAllowanceChargeReason2);
			
			// Invoice Due Date
			JLabel lblInvoiceDueDate = new JLabel("Invoice Due Date");
			lblInvoiceDueDate.setBounds(825, 120, 150, 15);
			frame.getContentPane().add(lblInvoiceDueDate);
				
			//  Invoice Line Headers
			JLabel lblHeader = new JLabel("INVOICE LINES:");
			lblHeader.setBounds(15, 200, 150, 15);
			frame.getContentPane().add(lblHeader);
			JLabel lblDescription = new JLabel("Invoiced Item - Name / Description");
			lblDescription.setBounds(15, 215, 200, 15);
			frame.getContentPane().add(lblDescription);
			//
			JLabel lblAsterix = new JLabel("*");
			lblAsterix.setBounds(325, 205, 60, 15);
			frame.getContentPane().add(lblAsterix);
			//
			JLabel lblAsterix2 = new JLabel("* base prices are rounded to 6 decimal places");
			lblAsterix2.setBounds(30, 580, 300, 15);
			frame.getContentPane().add(lblAsterix2);
	        //
			JLabel lblQuantity = new JLabel("Quantity");
			lblQuantity.setBounds(325, 220, 60, 15);
			frame.getContentPane().add(lblQuantity);
			//
			// Base Amount label is split over 2 lines
			JLabel lblBaseAmount1 = new JLabel("Base");
			lblBaseAmount1.setBounds(410, 205, 100, 15);
			frame.getContentPane().add(lblBaseAmount1);
			JLabel lblBaseAmount2 = new JLabel("Amount $");
			lblBaseAmount2.setBounds(410, 220, 100, 15);
			frame.getContentPane().add(lblBaseAmount2);
				
			// Item Level Allowance/Charge is split over 2 lines
			JLabel lblDiscount1 = new JLabel("Item Level");
			lblDiscount1.setBounds(495, 205, 100, 15);
			frame.getContentPane().add(lblDiscount1);
			JLabel lblDiscount2 = new JLabel("Discount $");
			lblDiscount2.setBounds(495, 220, 100, 15);
			frame.getContentPane().add(lblDiscount2);
			
			// Line Level Allowance/Charge is split over 2 lines
			JLabel lblLineDiscount1 = new JLabel("Line Level");
			lblLineDiscount1.setBounds(595, 205, 100, 15);
			frame.getContentPane().add(lblLineDiscount1);
			JLabel lblLineDiscount2 = new JLabel("Charge $(0.00)");
			lblLineDiscount2.setBounds(595, 220, 100, 15);
			frame.getContentPane().add(lblLineDiscount2);
			
			// Calculated Fields:
			JLabel lblPriceAmount = new JLabel("Price Amount");
			lblPriceAmount.setBounds(800, 220, 100, 15);
			frame.getContentPane().add(lblPriceAmount);
			
			JLabel lblLineExtensionAmount = new JLabel("Line Extension Amount ($0.00)");
			lblLineExtensionAmount.setBounds(920, 220, 200, 15);
			frame.getContentPane().add(lblLineExtensionAmount);
			
			JLabel lblLineExtensionAmountTotal = new JLabel("Line Extension Amount Total");
			lblLineExtensionAmountTotal.setBounds(740, 300, 200, 15);
			frame.getContentPane().add(lblLineExtensionAmountTotal);
			
			// Invoice Level Allowance / Charge	
			JLabel lblAllowanceChargeHeader = new JLabel("INVOICE LEVEL :            (Description)");
			lblAllowanceChargeHeader.setBounds(15, 300, 300, 15);
			frame.getContentPane().add(lblAllowanceChargeHeader);
			//
			JLabel lblILAllowance = new JLabel("Allowance");
			lblILAllowance.setBounds(325, 300, 80, 15);
			frame.getContentPane().add(lblILAllowance);
			//
			JLabel lblILCharge = new JLabel("Charge ($0.00)");
			lblILCharge.setBounds(410, 300, 150, 15);
			frame.getContentPane().add(lblILCharge);
			
			// Tax labels
			JLabel lblTaxableAmount = new JLabel("Taxable Amount");
			lblTaxableAmount.setBounds(810, 320, 100, 15);
			frame.getContentPane().add(lblTaxableAmount);
			
			JLabel lblTaxAmount = new JLabel("Tax Amount");
			lblTaxAmount.setBounds(833, 340, 100, 15);
			frame.getContentPane().add(lblTaxAmount);
			
			JLabel lblTaxExclusiveAmount = new JLabel("Tax Exclusive Amount");
			lblTaxExclusiveAmount.setBounds(777, 360, 200, 15);
			frame.getContentPane().add(lblTaxExclusiveAmount);
			
			JLabel lblTaxInclusiveAmount = new JLabel("Tax Inclusive Amount");
			lblTaxInclusiveAmount.setBounds(782, 380, 200, 15);
			frame.getContentPane().add(lblTaxInclusiveAmount);
			
			JLabel lblAllowanceAmount = new JLabel("Allowance Total Amount");
			lblAllowanceAmount.setBounds(765, 400, 200, 15);
			frame.getContentPane().add(lblAllowanceAmount);
			
			JLabel lblChargeAmount = new JLabel("Charge Total Amount");
			lblChargeAmount.setBounds(784, 420, 200, 15);
			frame.getContentPane().add(lblChargeAmount);
			
			JLabel lblPayableAmount = new JLabel("PAYABLE AMOUNT");
			lblPayableAmount.setBounds(799, 440, 200, 15);
			frame.getContentPane().add(lblPayableAmount);
			
			// Optional Fields (best practice)	
			JLabel lblOptionalHeader = new JLabel("------ OPTIONAL DATA (Best Practice) -----------------------");
			lblOptionalHeader.setForeground(Color.RED);
			lblOptionalHeader.setBounds(15, 350, 350, 15);
			frame.getContentPane().add(lblOptionalHeader);
			
			JLabel lblSupplierTaxIdentifier = new JLabel("Supplier Tax Identifier");
			lblSupplierTaxIdentifier.setBounds(15, 375, 200, 15);
			frame.getContentPane().add(lblSupplierTaxIdentifier);
			
			JLabel lblSupplierContactHeader = new JLabel("Supplier Contact Details :");
			lblSupplierContactHeader.setBounds(15, 405, 200, 15);
			frame.getContentPane().add(lblSupplierContactHeader);
			
			JLabel lblSupplierContactName = new JLabel(" - Name");
			lblSupplierContactName.setBounds(15, 425, 100, 15);
			frame.getContentPane().add(lblSupplierContactName);
			
			JLabel lblSupplierContactTelephone = new JLabel(" - Telephone");
			lblSupplierContactTelephone.setBounds(15, 445, 100, 15);
			frame.getContentPane().add(lblSupplierContactTelephone);
			
			JLabel lblSupplierContactEmail = new JLabel(" - eMail");
			lblSupplierContactEmail.setBounds(15, 465, 100, 15);
			frame.getContentPane().add(lblSupplierContactEmail);
			
			
			// Payment Means	
			JLabel lblPaymentMeansHeader = new JLabel("------ PAYMENT MEANS (Optional) -----------------------");
			lblPaymentMeansHeader.setForeground(Color.RED);
			lblPaymentMeansHeader.setBounds(410, 350, 350, 15);
			frame.getContentPane().add(lblPaymentMeansHeader);
			//
			JLabel lblPaymentMeans = new JLabel("Payment Means");
			lblPaymentMeans.setBounds(410, 375, 100, 15);
			frame.getContentPane().add(lblPaymentMeans);
			//
			JLabel lblPaymentMeansName = new JLabel("Payee Name");
			lblPaymentMeansName.setBounds(410, 400, 100, 15);
			frame.getContentPane().add(lblPaymentMeansName);
			//
			JLabel lblPaymentMeansAccount = new JLabel("Account");
			lblPaymentMeansAccount.setBounds(410, 425, 100, 15);
			frame.getContentPane().add(lblPaymentMeansAccount);
			
			// Invoice Response	
			JLabel lblInvoiceResponseHeader = new JLabel("---------- INVOICE RESPONSE ----------");
			lblInvoiceResponseHeader.setForeground(Color.RED);
			lblInvoiceResponseHeader.setBounds(900, 500, 200, 15);
			frame.getContentPane().add(lblInvoiceResponseHeader);
			//
			JLabel lblResonseCode= new JLabel("Response Code");
			lblResonseCode.setBounds(900, 520, 150, 15);
			frame.getContentPane().add(lblResonseCode);
			
			
			
			
			// Create the Combo Boxes		
			JComboBox APNorth = new JComboBox();
			APNorth.addItem(" ");
			APNorth.addItem("ACME Corporation");
			APNorth.addItem("AUSSIE-CORP");
			APNorth.addItem("Henrys Bakery");
			APNorth.addItem("WKG-North-Inbound");
			APNorth.setBounds(170, 15, 150, 18);
			frame.add(APNorth); 
					
			JComboBox APSouth = new JComboBox();
			APSouth.addItem(" ");
			APSouth.addItem("Aussie Foods Ltd");
			APSouth.addItem("Layer Security Test1");	
			APSouth.addItem("Layer Security Test2");
			APSouth.addItem("MBIE");
			APSouth.addItem("Roswell Robotics");
			APSouth.addItem("Kingsman Taylors");	
			APSouth.addItem("WKG-South-Inbound");	
			APSouth.setBounds(570, 15, 150, 18);
			frame.add(APSouth); 		
			
			// Define Participants based on selection
			// AP North
			APNorth.addItemListener(new ItemListener() {
		        @Override
		        public void itemStateChanged(ItemEvent arg0) {
		        	String sNorthParticipantID = String.valueOf(arg0.getItem());
		        	if (sNorthParticipantID.equals(" ")) {
		        		SenderSchemeID.setText(" ");
		            	SenderNZBN.setText(" ");       		
		        		SupplierName.setText(" ");
		            	SupplierAddress1.setText(" ");
		            	SupplierAddress2.setText(" ");
		            	SupplierCity.setText(" ");
		            	SupplierPostcode.setText(" ");  
		            	SupplierCountryCode.setText(" ");
		            	SupplierTaxIdentifier.setText(" ");
		            } 
		        	if (sNorthParticipantID.equals("ACME Corporation")) {
		        		SenderSchemeID.setText("0088");
		            	SenderNZBN.setText("9429050728848");       		
		        		SupplierName.setText("ACME Corporation");
		            	SupplierAddress1.setText("1 Roadrunner Road");
		            	SupplierAddress2.setText("The Square");
		            	SupplierCity.setText("Palmerston North");
		            	SupplierPostcode.setText("1234");  
		            	SupplierCountryCode.setText("NZ");
		            	SupplierTaxIdentifier.setText("111-111-111");
		            }   	
		        	if (sNorthParticipantID.equals("AUSSIE-CORP")) {
		        		SenderSchemeID.setText("0151");
		            	SenderNZBN.setText("80007079567");       		
		        		SupplierName.setText("AUSSIE-CORP");
		            	SupplierAddress1.setText("Shop 55");
		            	SupplierAddress2.setText("100 Military Road");
		            	SupplierCity.setText("Neutral Bay");
		            	SupplierPostcode.setText("NSW 2089");  
		            	SupplierCountryCode.setText("AU");
		            	SupplierTaxIdentifier.setText("80007079567");
		            }           
		            if (sNorthParticipantID.equals("Henrys Bakery")) {
		            	SenderSchemeID.setText("0088");
		            	SenderNZBN.setText("9429041742723");
		            	SupplierName.setText("Henrys Bakery");
		            	SupplierAddress1.setText("100 Queen Street");
		            	SupplierAddress2.setText("Wynyard Quarter");
		            	SupplierCity.setText("Auckland");
		            	SupplierPostcode.setText("1010");
		            	SupplierCountryCode.setText("NZ");
		            	SupplierTaxIdentifier.setText("222-222-222");
		            }
		            if (sNorthParticipantID.equals("WKG-North-Inbound")) {
		            	SenderSchemeID.setText("0088");
		            	SenderNZBN.setText("9429039349149");
		            	SupplierName.setText("WKG-North-Inbound");
		            	SupplierAddress1.setText("Inbound House");
		            	SupplierAddress2.setText("123 Great North Road");
		            	SupplierCity.setText("Auckland");
		            	SupplierPostcode.setText("3333"); 
		            	SupplierCountryCode.setText("NZ");
		            	SupplierTaxIdentifier.setText("333-333-333");
		            }
		            System.out.println("participant = " + sNorthParticipantID);   	     
		        }
		    });
			// AP South
			APSouth.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent arg0) {
					String sSouthParticipantID = String.valueOf(arg0.getItem());
				     System.out.println("participant = " + sSouthParticipantID); 
				     if (sSouthParticipantID.equals(" ")) {
				     	  ReceiverSchemeID.setText(" ");
			              ReceiverNZBN.setText(" ");
				    	  CustomerName.setText(" ");
			              CustomerAddress1.setText(" ");
			              CustomerAddress2.setText(" ");
			              CustomerCity.setText(" ");
			              CustomerPostcode.setText(" ");  
			              CustomerCountryCode.setText(" ");
			            }
				     if (sSouthParticipantID.equals("Aussie Foods Ltd")) {
			            	ReceiverSchemeID.setText("0151");
				            ReceiverNZBN.setText("23093952606");
			            	CustomerName.setText("Aussie Foods Ltd");
			            	CustomerAddress1.setText("100 Tobrook Road");
			            	CustomerAddress2.setText("South Yara");
			            	CustomerCity.setText("Melbourne");
			            	CustomerPostcode.setText("VIC 3141");
			            	CustomerCountryCode.setText("AU");
			            }
				     if (sSouthParticipantID.equals("Layer Security Test1")) {
			            	ReceiverSchemeID.setText("0151");
				            ReceiverNZBN.setText("99111222333");
			            	CustomerName.setText("Rick Harvey");
			            	CustomerAddress1.setText("Test Instance1");
			            	CustomerAddress2.setText("layersecurity.com");
			            	CustomerCity.setText("Melbourne");
			            	CustomerPostcode.setText("VIC 3333");
			            	CustomerCountryCode.setText("AU");
			            }
				     if (sSouthParticipantID.equals("Layer Security Test2")) {
			            	ReceiverSchemeID.setText("0151");
				            ReceiverNZBN.setText("99100100100");
			            	CustomerName.setText("Rick Harvey");
			            	CustomerAddress1.setText("Test Instance2");
			            	CustomerAddress2.setText("layersecurity.com");
			            	CustomerCity.setText("Melbourne");
			            	CustomerPostcode.setText("VIC 3333");
			            	CustomerCountryCode.setText("AU");
			            }
				     if (sSouthParticipantID.equals("MBIE")) {
			            	ReceiverSchemeID.setText("0088");
				            ReceiverNZBN.setText("9429050837823");
			            	CustomerName.setText("MBIE");
			            	CustomerAddress1.setText("Level 8");
			            	CustomerAddress2.setText("5 Stout Street");
			            	CustomerCity.setText("Wellington Central");
			            	CustomerPostcode.setText("6011");
			            	CustomerCountryCode.setText("NZ");
			            }
				     if (sSouthParticipantID.equals("Roswell Robotics")) {
				     	  ReceiverSchemeID.setText("0088");
			              ReceiverNZBN.setText("9429034362778");
				    	  CustomerName.setText("Roswell Robotics");
			              CustomerAddress1.setText("Hangar 18");
			              CustomerAddress2.setText("Area 51");
			              CustomerCity.setText("Roswell");
			              CustomerPostcode.setText("1947");  
			              CustomerCountryCode.setText("NZ");
			            }		     
			            if (sSouthParticipantID.equals("Kingsman Taylors")) {
			            	ReceiverSchemeID.setText("0088");
				            ReceiverNZBN.setText("9429049760224");
			            	CustomerName.setText("Kingsman Taylors");
			            	CustomerAddress1.setText("11 Saville Row");
			            	CustomerAddress2.setText("Raumati Beach");
			            	CustomerCity.setText("Paraparumu");
			            	CustomerPostcode.setText("5510");  
			            	CustomerCountryCode.setText("NZ");
			            }		      	            
			            if (sSouthParticipantID.equals("WKG-South-Inbound")) {
					     	  ReceiverSchemeID.setText("0007");
				              ReceiverNZBN.setText("5567125082");
					    	  CustomerName.setText("WKG-South-Inbound");
				              CustomerAddress1.setText("QualIT House Level 3");
				              CustomerAddress2.setText("3/22 The Terrace");
				              CustomerCity.setText("Wellington Central");
				              CustomerPostcode.setText("6012");  
				              CustomerCountryCode.setText("NZ");
				            }		            		            		            	            
				}
			});
			
			// TAX SCHEME		
			JComboBox TaxScheme = new JComboBox();
			TaxScheme.addItem("NZD GST 15%");
			TaxScheme.addItem("AUS GST 10%");
			TaxScheme.addItem("NZD Exempt 0%");
			TaxScheme.addItem("AUS Exempt 0%");
			TaxScheme.setBounds(970, 50, 175, 18);
			frame.add(TaxScheme); 
			// Add listener
			TaxScheme.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent arg0) {
					String sTaxScheme = String.valueOf(arg0.getItem());
					
		        	if (sTaxScheme.equals("NZD GST 15%")) {
		        		sCurrencyID = "NZD";
		        		sTaxCategoryID = "S";
		        		sPercent4 = "15"; 
		            } 
		        	if (sTaxScheme.equals("AUS GST 10%")) {
		        		sCurrencyID = "AUD";
		        		sTaxCategoryID = "S";
		        		sPercent4 = "10";
		            }
		        	if (sTaxScheme.equals("NZD Exempt 0%")) {
		        		sCurrencyID = "NZD";
		        		sTaxCategoryID = "E";
		        		sPercent4 = "0";
		            } 
		        	if (sTaxScheme.equals("AUS Exempt 0%")) {
		        		sCurrencyID = "AUD";
		        		sTaxCategoryID = "E";
		        		sPercent4 = "0";
		            }	        		        	
		        	 //Debug
				     System.out.println("Line 469 TaxScheme = " + sTaxScheme);
				     System.out.println("Line 470 sCurrencyID = " + sCurrencyID);
				}
			});	     
		        
			// Combo Box for Unit Code
			// TAX SCHEME		
			JComboBox UnitCode = new JComboBox();
			UnitCode.addItem("C62 - Standard Unit");
			UnitCode.addItem("KGM - Kilograms");
			UnitCode.addItem("MIN - Number of Minutes");
			UnitCode.addItem("DAY - Number of Days");								
			UnitCode.setBounds(970, 70, 175, 18);
			frame.add(UnitCode); 
			// Add listener
			UnitCode.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent arg0) {
					String sSelectedUnitCode = String.valueOf(arg0.getItem());	
					sUnitCode = sSelectedUnitCode.substring(0,3); 
					//Debug
					// System.out.println("Line 516 sUnitCode = " + sUnitCode);					
				}
			});
			
					
			//  Payment Means
			JComboBox PaymentMeans = new JComboBox();
			PaymentMeans.addItem(" ");
			PaymentMeans.addItem("Credit Transfer");
			PaymentMeans.addItem("Direct Debit");	
			PaymentMeans.addItem("Online Payment Service");
			PaymentMeans.setBounds(530, 375, 160, 18);
			frame.add(PaymentMeans); 		
			// Determine Payment Means Code based on selection
			PaymentMeans.addItemListener(new ItemListener() {
			@Override
				  public void itemStateChanged(ItemEvent arg0) {
				  String sPaymentMeans = String.valueOf(arg0.getItem());
				  //Debug
				  String sRandomBankAccountNumber;
				  Random r1 = new Random();
				  int x1 = r1.nextInt(10);
				  sRandomBankAccountNumber = "0" + String.valueOf(x1);
				  Random r2 = new Random();
				  int x2 = 1000 + r2.nextInt(9000);
				  String s2 = String.valueOf(x2);
				  sRandomBankAccountNumber = sRandomBankAccountNumber + "-" + s2;
				  Random r3 = new Random();
				  int x3 = 10000 + r3.nextInt(90000);
				  String s3 = String.valueOf(x3);
				  sRandomBankAccountNumber = sRandomBankAccountNumber + "-" + s3;
				  Random r4 = new Random();
				  int x4= 10000 + r4.nextInt(90000);
				  String s4 = String.valueOf(x4);
				  sRandomBankAccountNumber = sRandomBankAccountNumber + s4;
				  // Get Payment Means Code
				  if (sPaymentMeans.equals("Credit Transfer")) {
					  // set the payee name to the supplier name
					  String sSupplierName = SupplierName.getText();
					  PaymentMeansName.setText(sSupplierName);	
					  PaymentMeansAccount.setText(sRandomBankAccountNumber);
					  sPaymentMeansCode = "30";
				  }
				  if (sPaymentMeans.equals("Direct Debit")) {
					  // set the payee name to the supplier name
					  String sSupplierName = SupplierName.getText();
					  PaymentMeansName.setText(sSupplierName);	
					  PaymentMeansAccount.setText(sRandomBankAccountNumber);
					  sPaymentMeansCode = "49";
				  }
				  if (sPaymentMeans.equals("Online Payment Service")) {
					  // set the payee name to the supplier name
					  String sSupplierName = "www.onlinepayments.com";
					  PaymentMeansName.setText(sSupplierName);		
					  PaymentMeansAccount.setText(sRandomBankAccountNumber);
					  sPaymentMeansCode = "68";
				  }
				  
				  
				  
				  }
			});
			
			
			// INVOICE RESPONSE		
			JComboBox ResponseCode = new JComboBox();
			ResponseCode.addItem("AP - Accepted");
			ResponseCode.addItem("RE - Rejected");
			ResponseCode.setBounds(1000, 520, 150, 18);
			frame.add(ResponseCode);
			// Add listener
			ResponseCode.addItemListener(new ItemListener() {
			@Override
				public void itemStateChanged(ItemEvent arg0) {
					String sSelectedResponseCode = String.valueOf(arg0.getItem());	
					sResponseCode = sSelectedResponseCode.substring(0,2); 
					//Debug
					System.out.println("Line 728 sResponseCode = " + sResponseCode);					
					}
			});
			
			// Create Radio Buttons
	        JRadioButton payloadButton     = new JRadioButton("Create Payload only");
	        payloadButton.setSelected(true);
	        JRadioButton fullN2SButton    = new JRadioButton("SDBH Invoice North to South");
	        JRadioButton fullS2NButton = new JRadioButton("SDBH Invoice South to North");     

	        payloadButton.setBounds(650, 550, 200, 15);
			frame.getContentPane().add(payloadButton);
			fullN2SButton.setBounds(650, 565, 200, 15);
			frame.getContentPane().add(fullN2SButton);			
			fullS2NButton.setBounds(650, 580, 200, 15);
			frame.getContentPane().add(fullS2NButton);			

			
			//Group the radio buttons (so only 1 can be selected at a time)
		    ButtonGroup group = new ButtonGroup();
		    group.add(payloadButton);
		    group.add(fullN2SButton);
		    group.add(fullS2NButton);	    
		    
		    // Listeners to determine which button has been selected	
		    // sMODE is a string which is used to determine which XML is created
		    payloadButton.addActionListener(new ActionListener() {	 
		        @Override
		        public void actionPerformed(ActionEvent event) {
		            sMODE = "sPAYLOAD";
		        }
		    });
		    fullN2SButton.addActionListener(new ActionListener() {	 
		        @Override
		        public void actionPerformed(ActionEvent event) {
		            sMODE = "sFULLN2S";
		        }
		    });
		    fullS2NButton.addActionListener(new ActionListener() {	 
		        @Override
		        public void actionPerformed(ActionEvent event) {
		            sMODE = "sFULLS2N";
		        }
		    });
			
			
	        //////////////////////////////////////////////////////
			// CREATE XML                                       //
			// Create Button to form the XML on clicking        //
	        //////////////////////////////////////////////////////
	        
			JButton btnCreateXML = new JButton("Generate XML");
			btnCreateXML.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// get input
					String messageText = CustomerName.getText();
					XMLFile.create();
					JOptionPane.showMessageDialog(null, "XML Generated for "  + messageText + "'s invoice" );
				}
			});
			//
			// Display the Create XML button
			btnCreateXML.setBounds(410, 550, 200, 45);
			frame.getContentPane().add(btnCreateXML);
			
			
			// Invoice Response - Button
			//
			JButton btnResponseXML = new JButton("Response XML");
			btnResponseXML.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// get input
					String messageText = CustomerName.getText();
					XMLResponse.create();
					JOptionPane.showMessageDialog(null, "Invoice Response XML Generated for "  + messageText + "'s invoice" );
				}
			});
			//
			// Display the Invoice Response Create XML Button
			btnResponseXML.setBounds(900, 550, 200, 45);
			frame.getContentPane().add(btnResponseXML);
			
				
			//////////////////////////////////////////////////////
			//       CALCULATIONS (CALCULATE BUTTON)            //
			//////////////////////////////////////////////////////						
			
			// Calculate Button to create the line totals on clicking
			JButton btnCalculateLineExtensionAmounts = new JButton("Calculate");
			btnCalculateLineExtensionAmounts.addActionListener(new ActionListener() {
			   	public void actionPerformed(ActionEvent arg0) {
		    	 	// Set Price Amounts
			     	// priceAmount = baseAmount - discount
			   		// Initialize Null fields to Zero
			   		String baseAmount1 = BaseAmount1.getText();		   		
			   		if(baseAmount1.isEmpty()) {
			   			baseAmount1 = "0.00";
			   	    }  			   		
					String baseAmount2 = BaseAmount2.getText();
					if(baseAmount2.isEmpty()) {
			   			baseAmount2 = "0.00";
			   	    }							
					String baseAmount3 = BaseAmount3.getText();		
					if(baseAmount3.isEmpty()) {
			   			baseAmount3 = "0.00";
			   	    }		
					// Validate base amounts
					// Round to 6 decimal places
					// After Rounding write the rounded values back to the screen
					double nBaseAmount1 = 0.00;
			   		try {
			   			nBaseAmount1 = Double.parseDouble(baseAmount1);	   			
			   			nBaseAmount1 = (Math.round(nBaseAmount1 * 1000000.0))/1000000.0;
			   			String sBaseAmount1 = Double.toString(nBaseAmount1);
			   			BaseAmount1.setText(sBaseAmount1);		   			
	                } catch (NumberFormatException e) {
	                	JOptionPane.showMessageDialog(null, "Warning - BaseAmount1 is not a valid number" );
	                }
			   		double nBaseAmount2 = 0.00;
			   		try {
			   			nBaseAmount2 = Double.parseDouble(baseAmount2);
			   			nBaseAmount2 = (Math.round(nBaseAmount2 * 1000000.0))/1000000.0;
			   			String sBaseAmount2 = Double.toString(nBaseAmount2);
			   			BaseAmount2.setText(sBaseAmount2);
	                } catch (NumberFormatException e) {
	                	JOptionPane.showMessageDialog(null, "Warning - BaseAmount2 is not a valid number" );
	                }
			   		double nBaseAmount3 = 0.00;
			   		try {
			   			nBaseAmount3 = Double.parseDouble(baseAmount3);
			   			nBaseAmount3 = (Math.round(nBaseAmount3 * 1000000.0))/1000000.0;
			   			String sBaseAmount3 = Double.toString(nBaseAmount3);
			   			BaseAmount3.setText(sBaseAmount3);
	                } catch (NumberFormatException e) {
	                	JOptionPane.showMessageDialog(null, "Warning - BaseAmount3 is not a valid number" );
	                }
					
					// Get and Validate discount
					String discount1 = Discount1.getText();
					if(discount1.isEmpty()) {
						discount1 = "0.00";
			   	    }							
					String discount2 = Discount2.getText();
					if(discount2.isEmpty()) {
						discount2 = "0.00";
			   	    }							
					String discount3 = Discount3.getText();	
					if(discount3.isEmpty()) {
						discount3 = "0.00";
			   	    }		   		
					double nDiscount1 = 0.00;
			   		try {
			   			nDiscount1 = Double.parseDouble(discount1);
			   			nDiscount1 = (Math.round(nDiscount1 * 1000000.0))/1000000.0;
			   			String sDiscount1 = Double.toString(nDiscount1);
			   			Discount1.setText(sDiscount1);
	                } catch (NumberFormatException e) {
	                	JOptionPane.showMessageDialog(null, "Warning - Discount1 is not a valid number" );
	                }
			   		double nDiscount2 = 0.00;
			   		try {
			   			nDiscount2 = Double.parseDouble(discount2);
			   			nDiscount2 = (Math.round(nDiscount2 * 1000000.0))/1000000.0;
			   			String sDiscount2 = Double.toString(nDiscount2);
			   			Discount2.setText(sDiscount2);
	                } catch (NumberFormatException e) {
	                	JOptionPane.showMessageDialog(null, "Warning - Discount2 is not a valid number" );
	                }
			   		double nDiscount3 = 0.00;
			   		try {
			   			nDiscount3 = Double.parseDouble(discount3);
			   			nDiscount3 = (Math.round(nDiscount3 * 1000000.0))/1000000.0;
			   			String sDiscount3 = Double.toString(nDiscount3);
			   			Discount3.setText(sDiscount3);
	                } catch (NumberFormatException e) {
	                	JOptionPane.showMessageDialog(null, "Warning - Discount3 is not a valid number" );
	                }   	
			   		
			   		// Warning if no Buyer Reference or Purchase Order Reference
			   		String sReferenceCheck = BuyerReference.getText() + POReference.getText();		   				   		
					if(sReferenceCheck.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Warning - One of Buyer Reference OR Purchase Order Reference is mandatory" );				
			   	    }
			   							   		
			   		
			   		// Calculate Item Price after discount
			   		double nPriceAmount1 = nBaseAmount1 - nDiscount1;
			   		double nPriceAmount2 = nBaseAmount2 - nDiscount2;
			   		double nPriceAmount3 = nBaseAmount3 - nDiscount3;
			   		// Do some high level rounding to 6 decimal places
			   		nPriceAmount1 = (Math.round(nPriceAmount1 * 1000000.0))/1000000.0;
			   		nPriceAmount2 = (Math.round(nPriceAmount2 * 1000000.0))/1000000.0;
			   		nPriceAmount3 = (Math.round(nPriceAmount3 * 1000000.0))/1000000.0;
			   			 
			   		String sPriceAmount1 = Double.toString(nPriceAmount1);
			   		String sPriceAmount2 = Double.toString(nPriceAmount2);
			   		String sPriceAmount3 = Double.toString(nPriceAmount3);	
			   		
			   		// Debug
			   		System.out.println("sPriceAmount1 = " + sPriceAmount1);
			   		System.out.println("sPriceAmount2 = " + sPriceAmount2);
			   		System.out.println("sPriceAmount3 = " + sPriceAmount3);		   				   				   				   				   				   		   		
			   		
			   		// Validate Quantity - then calculate Line Extension Amount
			   		String quantity1 = Quantity1.getText();
			   		if(quantity1.isEmpty()) {
			   			quantity1 = "0";	
			   	    }	
			   		String quantity2 = Quantity2.getText();
			   		if(quantity2.isEmpty()) {
			   			quantity2 = "0";
			   	    }	
			   		String quantity3 = Quantity3.getText();
			   		if(quantity3.isEmpty()) {
			   			quantity3 = "0";
			   	    }	
			   		double nQuantity1 = 0.00;
			   		try {
			   			nQuantity1 = Double.parseDouble(quantity1);
	                } catch (NumberFormatException e) {
	                	JOptionPane.showMessageDialog(null, "Warning - Quantity1 is not a valid number" );
	                }
			   		double nQuantity2 = 0.00;
			   		try {
			   			nQuantity2 = Double.parseDouble(quantity2);
	                } catch (NumberFormatException e) {
	                	JOptionPane.showMessageDialog(null, "Warning - Quantity2 is not a valid number" );
	                }
			   		double nQuantity3 = 0.00;
			   		try {
			   			nQuantity3 = Double.parseDouble(quantity3);
	                } catch (NumberFormatException e) {
	                	JOptionPane.showMessageDialog(null, "Warning - Quantity3 is not a valid number" );
	                }
			   		
			   		// Get and validate the line charges
			   		String sLineCharge1 = LineCharge1.getText();
			   		if(sLineCharge1.isEmpty()) {
			   			sLineCharge1 = "0";	
			   	    }	
			   		String sLineCharge2 = LineCharge2.getText();
			   		if(sLineCharge2.isEmpty()) {
			   			sLineCharge2 = "0";	
			   	    }	
			   		String sLineCharge3 = LineCharge3.getText();
			   		if(sLineCharge3.isEmpty()) {
			   			sLineCharge3 = "0";	
			   	    }	
			   		double nLineCharge1 = 0.00;
			   		try {
			   			nLineCharge1 = Double.parseDouble(sLineCharge1);
	                } catch (NumberFormatException e) {
	                	JOptionPane.showMessageDialog(null, "Warning - LineCharge1 is not a valid number" );
	                }
			   		double nLineCharge2 = 0.00;
			   		try {
			   			nLineCharge2 = Double.parseDouble(sLineCharge2);
	                } catch (NumberFormatException e) {
	                	JOptionPane.showMessageDialog(null, "Warning - LineCharge2 is not a valid number" );
	                }
			   		double nLineCharge3 = 0.00;
			   		try {
			   			nLineCharge3 = Double.parseDouble(sLineCharge3);
	                } catch (NumberFormatException e) {
	                	JOptionPane.showMessageDialog(null, "Warning - LineCharge3 is not a valid number" );
	                }
			   		
			   		// Debug
			   		System.out.println("sLineCharge1 = " + sLineCharge1);
			   		System.out.println("sLineCharge2 = " + sLineCharge2);
			   		System.out.println("sLineCharge3 = " + sLineCharge3);	
			   		

			   		// Calculate the Line Extension Amount for each line
			   		double nLineExtensionAmount1 = (nQuantity1 * nPriceAmount1) + nLineCharge1;
			   		double nLineExtensionAmount2 = (nQuantity2 * nPriceAmount2) + nLineCharge2;
			   		double nLineExtensionAmount3 = (nQuantity3 * nPriceAmount3) + nLineCharge3;
			   		
			   		// Line extension amounts should be rounded to 2 decimal places		   			   		
			   		nLineExtensionAmount1 = (Math.round(nLineExtensionAmount1 * 100.0))/100.0;
			   		nLineExtensionAmount2 = (Math.round(nLineExtensionAmount2 * 100.0))/100.0;
			   		nLineExtensionAmount3 = (Math.round(nLineExtensionAmount3 * 100.0))/100.0;
			   		

			      	// Use a temporary value just for readability
			   		double ntemp = nLineExtensionAmount1 + nLineExtensionAmount2 + nLineExtensionAmount3;
			   		double nLineExtensionAmountTotal = (Math.round(ntemp * 100.0))/100.0;
			   		
			   		// Taxable Amount is the sum of lines + charges - allowances
			   		
			   		// Invoice Level Allowance / Charge
			   		String sInVoiceLevelAllowance = InvoiceLevelAllowance.getText();
			   		if(sInVoiceLevelAllowance.isEmpty()) {
			   			sInVoiceLevelAllowance = "0.00";
			   	    }	
			   		String sInVoiceLevelCharge = InvoiceLevelCharge.getText();
			   		if(sInVoiceLevelCharge.isEmpty()) {
			   			sInVoiceLevelCharge = "0.00";
			   	    }	
			   		double nInvoiceLevelAllowance = Double.parseDouble(sInVoiceLevelAllowance);
			   		double nInvoiceLevelCharge = Double.parseDouble(sInVoiceLevelCharge);
			   		
   		
			   		String sLineExtensionAmount1 = Double.toString(nLineExtensionAmount1);
			   		String sLineExtensionAmount2 = Double.toString(nLineExtensionAmount2);
			   		String sLineExtensionAmount3 = Double.toString(nLineExtensionAmount3);
			   		String sLineExtensionAmountTotal = Double.toString(nLineExtensionAmountTotal);
			   		
			   		// Debug
			   		System.out.println("sLineExtensionAmount1 = " + sLineExtensionAmount1);
			   		System.out.println("sLineExtensionAmount2 = " + sLineExtensionAmount2);
			   		System.out.println("sLineExtensionAmount3 = " + sLineExtensionAmount3);
			   		
			   		////////////////////////////////////////////////////////
			   		//    Tax - Get the tax rates from the screen         //
			   		////////////////////////////////////////////////////////
			   		
			   		// Calculate Taxable Amount
			   		Double nTaxableAmount = 0.00;
			   		
			   		
			   		sPercent1 = sPercent4;
			   		sPercent2 = sPercent4;
			   		sPercent3 = sPercent4;
			   		nTaxableAmount = nTaxableAmount + nLineExtensionAmount1 + nLineExtensionAmount2 + nLineExtensionAmount3;
			   		
			   		// For future enhancement - mixed tax rates

			   		//String sTaxRegime1 = TaxCategory1.getText();
			   		//if (sTaxRegime1.equals("NZD GST 15%")) {
		        	//	sCurrencyID = "NZD";
		        	//	sPercent1 = "15";	    
		        	//	nTaxableAmount = nTaxableAmount + nLineExtensionAmount1;
		            //} 
		        	//if (sTaxRegime1.equals("AUS GST 10%")) {
		        	//	sCurrencyID = "AUD";
		        	//	sPercent1 = "10";
		        	//	nTaxableAmount = nTaxableAmount + nLineExtensionAmount1;
		            //}
		        	//if (sTaxRegime1.equals("NZD Exempt 0%")) {
		        	//	sCurrencyID = "NZD";
		        	//	sPercent1 = "0";
		            //} 
		        	//if (sTaxRegime1.equals("AUS Exempt 0%")) {
		        	//	sCurrencyID = "AUD";
		        	//	sPercent1 = "0";
		            //}
			   		
		        	//String sTaxRegime2 = TaxCategory2.getText();
			   		//if (sTaxRegime2.equals("NZD GST 15%")) {
		        	//	sCurrencyID = "NZD";
		        	//	sPercent2 = "15";	  
		        	//	nTaxableAmount = nTaxableAmount + nLineExtensionAmount2;
		            //} 
		        	//if (sTaxRegime2.equals("AUS GST 10%")) {
		        	//	sCurrencyID = "AUD";
		        	//	sPercent2 = "10";
		        	//	nTaxableAmount = nTaxableAmount + nLineExtensionAmount2;
		            //}
		        	//if (sTaxRegime2.equals("NZD Exempt 0%")) {
		        	//	sCurrencyID = "NZD";
		        	//	sPercent2 = "0";
		            //} 
		        	//if (sTaxRegime2.equals("AUS Exempt 0%")) {
		        	//	sCurrencyID = "AUD";
		        	//	sPercent2 = "0";
		            //}
			   		
		        	//String sTaxRegime3 = TaxCategory3.getText();
			   		//if (sTaxRegime3.equals("NZD GST 15%")) {
		        	//	sCurrencyID = "NZD";
		        	//	sPercent3 = "15";	 
		        	//	nTaxableAmount = nTaxableAmount + nLineExtensionAmount3;
		            //} 
		        	//if (sTaxRegime3.equals("AUS GST 10%")) {
		        	//	sCurrencyID = "AUD";
		        	//	sPercent3 = "10";
		        	//	nTaxableAmount = nTaxableAmount + nLineExtensionAmount3;
		            //}
		        	//if (sTaxRegime3.equals("NZD Exempt 0%")) {
		        	//	sCurrencyID = "NZD";
		        	//	sPercent3 = "0";
		            //} 
		        	//if (sTaxRegime3.equals("AUS Exempt 0%")) {
		        	//	sCurrencyID = "AUD";
		        	//	sPercent3 = "0";
		            //}
		        	
		        	// Default the Invoice Level Charges/Allowance to the drop down
		        	Double nTaxRate4 = Double.parseDouble(sPercent4);
		        		        	
		        	nTaxableAmount = nTaxableAmount + nInvoiceLevelCharge - nInvoiceLevelAllowance;
		        	// debug
		        	System.out.println(" line 995 : Taxable Amount = " + nTaxableAmount + " " + nInvoiceLevelCharge + " " + nInvoiceLevelAllowance);
		        	
			   		nTaxableAmount = (Math.round(nTaxableAmount * 100.0))/100.0;	   		
			   		String sTaxableAmount = Double.toString(nTaxableAmount);
			   		double nTaxAmount = (Math.round(nTaxRate4 * nTaxableAmount))/100.0;
			   		String sTaxAmount = Double.toString(nTaxAmount);
			   		
			   		Double nTaxExclusiveAmount = (Math.round(nTaxableAmount * 100.0))/100.0;
			   		
			   		Double nTaxInclusiveAmount = (Math.round((nTaxableAmount + nTaxAmount) * 100.0))/100.0;
			   		String sTaxExclusiveAmount = Double.toString(nTaxExclusiveAmount);
			   		String sTaxInclusiveAmount = Double.toString(nTaxInclusiveAmount);
			   		
			   		// Document Level Allowance / Charge must be rounded to 2 decimal places
			   		nInvoiceLevelAllowance = (Math.round((nInvoiceLevelAllowance) * 100.0))/100.0;
			   		nInvoiceLevelCharge = (Math.round((nInvoiceLevelCharge) * 100.0))/100.0;
			   		
			   		// double nAllowanceTotalAmount = 0.00;
			   		// double nChargeTotalAmount = nAllowanceCharge;
			   		// 
			   		String sInvoiceLevelAllowance = Double.toString(nInvoiceLevelAllowance);
			   		String sInvoiceLevelCharge = Double.toString(nInvoiceLevelCharge);
			   		
			   		// String sAllowanceTotalAmount = Double.toString(nAllowanceTotalAmount);
			   		
			   		// String sChargeTotalAmount = Double.toString(nChargeTotalAmount);
			   		
			   		double nPayableAmount = (Math.round((nTaxInclusiveAmount) * 100.0))/100.0;
			   
			   		String sPayableAmount = Double.toString(nPayableAmount);
			   			        
			   		////////////////////////////////////////////////////////
			   		/// Now set the calculated values back to the screen ///
			   		/// This should also include rounded values          ///
			   		////////////////////////////////////////////////////////
			   		
			   		PriceAmount1.setText(sPriceAmount1);
			   		PriceAmount2.setText(sPriceAmount2);
			   		PriceAmount3.setText(sPriceAmount3);
			   		LineExtensionAmount1.setText(sLineExtensionAmount1);
			   		LineExtensionAmount2.setText(sLineExtensionAmount2);
			   		LineExtensionAmount3.setText(sLineExtensionAmount3);
			   		LineExtensionAmountTotal.setText(sLineExtensionAmountTotal);
			   		TaxableAmount.setText(sTaxableAmount);
			   		TaxAmount.setText(sTaxAmount);
			   		TaxExclusiveAmount.setText(sTaxExclusiveAmount);
			   		TaxInclusiveAmount.setText(sTaxInclusiveAmount);
			   		
			   //		AllowanceTotalAmount.setText(sAllowanceTotalAmount);
			   //		ChargeTotalAmount.setText(sChargeTotalAmount);
			   		
			   		AllowanceTotalAmount.setText(sInvoiceLevelAllowance);
			   		ChargeTotalAmount.setText(sInvoiceLevelCharge);
			   		
			   		PayableAmount.setText(sPayableAmount);
			   		  		
			     	JOptionPane.showMessageDialog(null, "Invoice totals successfully calculated" );
					}
				});
			
			// Set the position of the Calculate button
			btnCalculateLineExtensionAmounts.setBounds(685, 240, 100, 45);
			frame.getContentPane().add(btnCalculateLineExtensionAmounts);
			
			
			//////////////////////////////////////////////////////////////////
			//                                                              //
			//                ALL INPUT TEXT BOXES HERE                     //
			//                                                              //
			//////////////////////////////////////////////////////////////////
			
			
			SenderSchemeID = new JTextField();
			SenderSchemeID.setBounds(170, 35, 40, 15);
			frame.getContentPane().add(SenderSchemeID);
			
			SenderNZBN = new JTextField();
			SenderNZBN.setBounds(215, 35, 105, 15);
			frame.getContentPane().add(SenderNZBN);

			ReceiverSchemeID = new JTextField();
			ReceiverSchemeID.setBounds(570, 35, 40, 15);
			frame.getContentPane().add(ReceiverSchemeID);
			
			ReceiverNZBN = new JTextField();
			ReceiverNZBN.setBounds(615, 35, 105, 15);
			frame.getContentPane().add(ReceiverNZBN);
				
			// Supplier Input fields - adding 15 to 2nd each time
			SupplierName = new JTextField();
			SupplierName.setBounds(170, 65, 150, 15);
			frame.getContentPane().add(SupplierName);
			
			SupplierAddress1 = new JTextField();
			SupplierAddress1.setBounds(170, 80, 150, 15);
			frame.getContentPane().add(SupplierAddress1);
			
			SupplierAddress2 = new JTextField();
			SupplierAddress2.setBounds(170, 95, 150, 15);
			frame.getContentPane().add(SupplierAddress2);
			
			SupplierCity = new JTextField();
			SupplierCity.setBounds(170, 110, 150, 15);
			frame.getContentPane().add(SupplierCity);
			
			SupplierPostcode = new JTextField();
			SupplierPostcode.setBounds(170, 125, 150, 15);
			frame.getContentPane().add(SupplierPostcode);
			
			SupplierCountryCode = new JTextField();
			SupplierCountryCode.setBounds(170, 140, 50, 15);
			frame.getContentPane().add(SupplierCountryCode);
			
			// Customer Input Fields
			CustomerName = new JTextField();
			CustomerName.setBounds(570, 65, 150, 15);
			frame.getContentPane().add(CustomerName);
			
			CustomerAddress1 = new JTextField();
			CustomerAddress1.setBounds(570, 80, 150, 15);
			frame.getContentPane().add(CustomerAddress1);
			
			CustomerAddress2 = new JTextField();
			CustomerAddress2.setBounds(570, 95, 150, 15);
			frame.getContentPane().add(CustomerAddress2);
			
			CustomerCity = new JTextField();
			CustomerCity.setBounds(570, 110, 150, 15);
			frame.getContentPane().add(CustomerCity);
			
			CustomerPostcode = new JTextField();
			CustomerPostcode.setBounds(570, 125, 150, 15);
			frame.getContentPane().add(CustomerPostcode);	
			
			CustomerCountryCode = new JTextField();
			CustomerCountryCode.setBounds(570, 140, 50, 15);
			frame.getContentPane().add(CustomerCountryCode);
			
			// Mandatory for XML		
			// Buyer Reference & Purchase Order Reference
			 BuyerReference = new JTextField();
			 BuyerReference.setBounds(970, 15, 150, 15);
			 frame.getContentPane().add(BuyerReference);
			 POReference = new JTextField();
			 POReference.setBounds(970, 30, 150, 15);
			 frame.getContentPane().add(POReference);
			 
			 // Invoice charge/allowance reason
			 InvoiceLineChargeReason = new JTextField();
			 InvoiceLineChargeReason.setBounds(970, 100, 150, 15);
			 frame.getContentPane().add(InvoiceLineChargeReason);
			 InvoiceLineChargeReason.setText(sAllowanceChargeReason);
			 	 
			 // Invoice Lines:
			 GoodsDescription1 = new JTextField();
			 GoodsDescription1.setBounds(15,240,305,15);
			 frame.getContentPane().add(GoodsDescription1);
			 GoodsDescription2 = new JTextField();
			 GoodsDescription2.setBounds(15,255,305,15);
			 frame.getContentPane().add(GoodsDescription2);
			 GoodsDescription3 = new JTextField();
			 GoodsDescription3.setBounds(15,270,305,15);
			 frame.getContentPane().add(GoodsDescription3);
			 // Quantity
			 Quantity1 = new JTextField();
			 Quantity1.setBounds(325,240,80,15);
			 frame.getContentPane().add(Quantity1);
			 Quantity2 = new JTextField();
			 Quantity2.setBounds(325,255,80,15);
			 frame.getContentPane().add(Quantity2);
			 Quantity3 = new JTextField();
			 Quantity3.setBounds(325,270,80,15);
			 frame.getContentPane().add(Quantity3);
			 // Base Amount
			 BaseAmount1 = new JTextField();
			 BaseAmount1.setBounds(410,240,80,15);
			 frame.getContentPane().add(BaseAmount1);
			 BaseAmount2 = new JTextField();
			 BaseAmount2.setBounds(410,255,80,15);
			 frame.getContentPane().add(BaseAmount2);
			 BaseAmount3 = new JTextField();
			 BaseAmount3.setBounds(410,270,80,15);
			 frame.getContentPane().add(BaseAmount3);
			 // AllowanceCharge
			 AllowanceChargeDescription = new JTextField();
			 AllowanceChargeDescription.setBounds(15,315,305,15);
			 frame.getContentPane().add(AllowanceChargeDescription);	
			 // enhancement 30/11/2020
			 // split allowance/charge
			 InvoiceLevelAllowance = new JTextField();
			 InvoiceLevelAllowance.setBounds(325,315,80,15);
			 frame.getContentPane().add(InvoiceLevelAllowance);
			 //
			 InvoiceLevelCharge = new JTextField();
			 InvoiceLevelCharge.setBounds(410,315,80,15);
			 frame.getContentPane().add(InvoiceLevelCharge);		 
			 
			 // Discount (item level - adjustment to price)
			 Discount1 = new JTextField();
			 Discount1.setBounds(495,240,80,15);
			 frame.getContentPane().add(Discount1);
			 Discount2 = new JTextField();
			 Discount2.setBounds(495,255,80,15);
			 frame.getContentPane().add(Discount2);
			 Discount3 = new JTextField();
			 Discount3.setBounds(495,270,80,15);
			 frame.getContentPane().add(Discount3);

			LineCharge1 = new JTextField();
			LineCharge1.setBounds(595,240,80,15);
			frame.getContentPane().add(LineCharge1);
			
			LineCharge2 = new JTextField();
			LineCharge2.setBounds(595,255,80,15);	
			frame.getContentPane().add(LineCharge2);
			
			LineCharge3 = new JTextField();
			LineCharge3.setBounds(595,270,80,15);	
			frame.getContentPane().add(LineCharge3);
			 		 
			 // Calculated Fields - Price Amount
			 PriceAmount1 = new JTextField();
			 PriceAmount1.setBounds(800,240,100,15);
			 PriceAmount1.setText("CALCULATED");
			 frame.getContentPane().add(PriceAmount1);
			 PriceAmount2 = new JTextField();
			 PriceAmount2.setBounds(800,255,100,15);
			 PriceAmount2.setText("CALCULATED");
			 frame.getContentPane().add(PriceAmount2);
			 PriceAmount3 = new JTextField();
			 PriceAmount3.setBounds(800,270,100,15);
			 PriceAmount3.setText("CALCULATED");
			 frame.getContentPane().add(PriceAmount3);
			 
			 // Calculated Fields - Line Extension Amount
			 LineExtensionAmount1 = new JTextField();
			 LineExtensionAmount1.setBounds(920,240,100,15);
			 LineExtensionAmount1.setText("CALCULATED");
			 frame.getContentPane().add(LineExtensionAmount1);
			 LineExtensionAmount2 = new JTextField();
			 LineExtensionAmount2.setBounds(920,255,100,15);
			 LineExtensionAmount2.setText("CALCULATED");
			 frame.getContentPane().add(LineExtensionAmount2);
			 LineExtensionAmount3 = new JTextField();
			 LineExtensionAmount3.setBounds(920,270,100,15);
			 LineExtensionAmount3.setText("CALCULATED");
			 frame.getContentPane().add(LineExtensionAmount3);
			 LineExtensionAmountTotal = new JTextField();
			 LineExtensionAmountTotal.setBounds(920,300,100,15);
			 LineExtensionAmountTotal.setText("CALCULATED");
			 frame.getContentPane().add(LineExtensionAmountTotal);
			 
			 // Calculated Fields - Tax
			 TaxableAmount = new JTextField();
			 TaxableAmount.setBounds(920,320,100,15);
			 TaxableAmount.setText("CALCULATED");
			 frame.getContentPane().add(TaxableAmount);
			 
			 TaxAmount = new JTextField();
			 TaxAmount.setBounds(920,340,100,15);
			 TaxAmount.setText("CALCULATED");
			 frame.getContentPane().add(TaxAmount);
			 
			 TaxExclusiveAmount = new JTextField();
			 TaxExclusiveAmount.setBounds(920,360,100,15);
			 TaxExclusiveAmount.setText("CALCULATED");
			 frame.getContentPane().add(TaxExclusiveAmount);
			 
			 TaxInclusiveAmount = new JTextField();
			 TaxInclusiveAmount.setBounds(920,380,100,15);
			 TaxInclusiveAmount.setText("CALCULATED");
			 frame.getContentPane().add(TaxInclusiveAmount);
			 
			 AllowanceTotalAmount = new JTextField();
			 AllowanceTotalAmount.setBounds(920,400,100,15);
			 AllowanceTotalAmount.setText("CALCULATED");
			 frame.getContentPane().add(AllowanceTotalAmount);
			 
			 ChargeTotalAmount = new JTextField();
			 ChargeTotalAmount.setBounds(920,420,100,15);
			 ChargeTotalAmount.setText("CALCULATED");
			 frame.getContentPane().add(ChargeTotalAmount);
			 
			 PayableAmount = new JTextField();
			 PayableAmount.setBounds(920,440,100,15);
			 PayableAmount.setText("CALCULATED");
			 frame.getContentPane().add(PayableAmount);
			 
			 // ***   Optional Fields   ***
			 
			 // Invoice Due Date - set default date today + 30 days
			 InvoiceDueDate = new JTextField();
			 InvoiceDueDate.setBounds(970,120,100,15);
		     // Get date as string
			 LocalDate today = LocalDate.now(); 
			 LocalDate dueDate = today.plusDays(30);	
			 String sDefaultDueDate = dueDate.toString();
			 InvoiceDueDate.setText(sDefaultDueDate);
			 frame.getContentPane().add(InvoiceDueDate);
			 
			 // Supplier Tax Identifier
			 SupplierTaxIdentifier = new JTextField();
			 SupplierTaxIdentifier.setBounds(170,375,150,15);
			 frame.getContentPane().add(SupplierTaxIdentifier);
			 
			 // Supplier Contact Details
			 SupplierContactName = new JTextField();
			 SupplierContactName.setBounds(170,425,150,15);
			 frame.getContentPane().add(SupplierContactName);
			 //
			 SupplierContactTelephone = new JTextField();
			 SupplierContactTelephone.setBounds(170,445,150,15);
			 frame.getContentPane().add(SupplierContactTelephone);
			 //
			 SupplierContactEmail = new JTextField();
			 SupplierContactEmail.setBounds(170,465,150,15);
			 frame.getContentPane().add(SupplierContactEmail);
			 
			 PaymentMeansName = new JTextField();
			 PaymentMeansName.setBounds(530, 400, 150, 15);
			 frame.getContentPane().add(PaymentMeansName);
			 
			 PaymentMeansAccount = new JTextField();
			 PaymentMeansAccount.setBounds(530, 425, 150, 15);
			 frame.getContentPane().add(PaymentMeansAccount);

			 
	}
}
