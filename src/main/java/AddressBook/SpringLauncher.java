/**
 * Created by sarrankanpathmanatha on 1/26/2017.
 */

package AddressBook;


import javax.swing.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class SpringLauncher {

    public static void main(String[] args) {
        String[] contextPaths = new String[]{"app-context.xml"};
        new ClassPathXmlApplicationContext(contextPaths);
    }
}
