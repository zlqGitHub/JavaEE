package nuc.sw.i18n;
import java.util.ResourceBundle;  //����һ����Դ��
import java.util.Locale;   //��Ӧһ���ض��Ĺ���/�������Ի���

@SuppressWarnings("unused")
public class LocaleList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale[] localeList = Locale.getAvailableLocales();  //����java��֧�ֵ�ȫ�����Һ����Ե�����
		for(Locale l : localeList) {
			System.out.println(l.getDisplayCountry()+"="+l.getCountry()+" "+l.getDisplayLanguage()+"="+l.getLanguage());
		}

	}

}
