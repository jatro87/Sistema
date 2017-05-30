import vista.jd_acceso;
import vista.jfPrincipal;
import vista.jf_asamblea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jatro
 */
public class sistema {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        jfPrincipal sutsha;
        jf_asamblea asamblea;
        
        jd_acceso acceso = new jd_acceso(null, true);
        acceso.setVisible(true);
        
        if(acceso.asamblea())
            asamblea = new jf_asamblea(null);
        else
            sutsha = new jfPrincipal();
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                acceso = new jd_acceso(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
        
//        ClassConectaBD conexionBD = new ClassConectaBD();
//        CEjecutaArchivo ejecuta = new CEjecutaArchivo();
//        CftpClient ftp =  new CftpClient();
//        CBarraProgreso barritaProgreso = new CBarraProgreso();
//         jd_progreso prog = new jd_progreso(null, true);
//        
//        Object [] res = conexionBD.ejecutarConsulta1("getUpdate(?,?,?,?,?)", new Object[]{"Cuauhpipiltin V 2.0"}, new String []{"String","String", "String", "String"});
//       
//        if(!res [0].equals("Software Actualizado") ){
//            
//            int re = JOptionPane.showConfirmDialog(null, res [0].toString() + " ¿Deseas Actualizar?", "Actualizacion Disponible", JOptionPane.YES_NO_OPTION);
//            
//            if(re == JOptionPane.YES_OPTION){
//                
//                barritaProgreso.start();
//                barritaProgreso.setJDProgreso(prog);
//                
//                barritaProgreso.setProgreso(0);
//                barritaProgreso.setTexto("Iniciando  ...");
//                
//                SwingWorker<String, Void> worker = new SwingWorker<String, Void>() {
//                    
//                    @Override
//                    protected String doInBackground(){
//
//                         barritaProgreso.setProgreso(50);
//                         barritaProgreso.setTexto("Obteniendo Actualizacion  ...");
//                        
//                         if(ftp.getUpdate(res [1].toString() + "//" + res[2].toString() + res[3].toString())){
//                             
//                            barritaProgreso.setProgreso(100);
//                            barritaProgreso.setTexto("Completado  ...");
//                            
//                            prog.setVisible(false);
//                            
//                            JOptionPane.showMessageDialog(null, "El Sistema se Reiniciara", "Aviso de Reinicio", JOptionPane.INFORMATION_MESSAGE);
//                            
//                            ejecuta.ejecutaActualizacion();
//                            
//                            }
//                         else{
//                             
//                             barritaProgreso.setProgreso(90);
//                             barritaProgreso.setTexto("Error al Obtener La Actualizacion, Consulta Al Administrador Del Sistema  ...");
//                             
//                             try {
//                                 Thread.sleep(1000);
//                             } catch (InterruptedException ex) {
//                                 Logger.getLogger(sistema.class.getName()).log(Level.SEVERE, null, ex);
//                             }
//                             
//                             prog.setVisible(false);
//                             
//                         }
//                        return "";
//
//                    }   
//
//                    @Override
//                    protected void done() {
//                        prog.setVisible(false);
//                    }
//                    };
//
//            worker.execute();
//
//            prog.setVisible(true);   
//
//            }
//            
//        }
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new jfPrincipal().setVisible(true);
//            }
//        });
//        
       
////        File x = new File("temp" + File.separator + "sin_foto.jpg");
////        if(x.exists())
////            System.out.println(x.getAbsolutePath());
        
//        ClassConectaBD conexion = new ClassConectaBD();
//        
//        
//        File x = new File("C:" + File.separator + "temp.csv");
//        
//        Scanner lee = new Scanner(x);
//        
//        String [] f;
//        String h = "";
//        int c = 0;
//        while(lee.hasNextLine()){
//        
//            h = lee.nextLine();
//            
//            f = h.split(",");
//            
//            System.out.println(f[0] + "-" + f[1]);
//            
//            conexion.ejecutarConsulta1("UpdateTelefonoTem(?,?)", new Object []{f[0],f[1]}, new String []{});
//            
//            c++;
//            
//        }
//        
//        System.out.println(c);
//        
    }
    
}
