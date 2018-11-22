package nuc.sw.i18n;
import java.util.ResourceBundle;  //加载一个资源包
import java.util.Locale;   //对应一个特定的国家/区域、语言环境

@SuppressWarnings("unused")
public class LocaleList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale[] localeList = Locale.getAvailableLocales();  //返回java所支持的全部国家和语言的数组
		for(Locale l : localeList) {
			System.out.println(l.getDisplayCountry()+"="+l.getCountry()+" "+l.getDisplayLanguage()+"="+l.getLanguage());
		}

	}

}
