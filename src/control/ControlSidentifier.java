package control;

import java.io.*;

public class ControlSidentifier {
    public boolean verifieridentite(String loginSaisi, String mdpSaisi) throws IOException {
        String login;
        String mdp;
        boolean verifok;
        FileReader flux = new FileReader("./moteur/mdp/admin.txt");
        BufferedReader buffer = new BufferedReader(flux);

        login= buffer.readLine();
        mdp=buffer.readLine();
        return (login.equals(loginSaisi)) && (mdp.equals(mdpSaisi));


    }
}
