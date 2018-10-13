#include <stdio.h>
#include <windows.h>
#include <string.h>
#define N 100
struct date_type //�����������// 
{
	int year;
	int month;
	int day;
}; 
struct employee  /*����һ���ṹ��*/ 
{  
   int num;  
   char name[20]; 
   char sex[6];   
   struct date_type birthday;   
   char marry[30]; 
   char job[30];  
   char addr[30]; 
   char tel[20];
   char e_addr[20];  
}em[100];        
void menu(); 
void input(); 
void save(int); 
void display(); 
void del();  
void search(); 
void search_num(); 
void search_name(); 
void search_job();  
void modify();  /*���������*/ 
int main() 
{
	   
    int n,flag; 
    char a;
	menu();
    
	  do{
	      printf("��ѡ������Ҫ�����Ĳ���(1--8):\n"); 
       scanf("%d",&n); 
       if(n>=1&&n<=7) 
        {
	       flag=1; 
        } 
       else
        {  
           flag=0;  
           printf("����������������ѡ��!");  
        } 
    	}	while(flag==0);
      
    //while(flag==0); 
    while(flag==1)
        {
            switch(n) 
            {
	            case 1:printf("     ***����ְ����Ϣ***     \n");
				       printf("\n");input();break;  
                case 2:printf("     ***���ְ����Ϣ***     \n");
	                   printf("\n");display();break; 
			    case 3:printf("     ***�����Ų�ѯְ����Ϣ***     \n");
			       	   printf("\n");search_num();break;
                case 4:printf("     ***��������ѯְ����Ϣ***     \n");
			       	   printf("\n");search_name();break;            
   	            case 5:printf("     ***��ְ�Ʋ�ѯְ����Ϣ***     \n");
			       	   printf("\n");search_job();break;            
				case 6:printf("     ***ɾ��ְ����Ϣ***     \n");
				       printf("\n");del();break;
				case 7:printf("     ***�޸�ְ����Ϣ***     \n");
				       printf("\n"); modify();break;   
                case 8:exit(0);break; 
                      default :break; 
            }  
            getchar(); 
            printf("\n");  
            printf("�Ƿ��������(y or n):\n"); 
			scanf("%c",&a); 
            if(a=='y') 
            {
	            flag=1;
				system("cls");/*����*/ 
				menu();/*���ò˵�����*/  
                printf("���ٴ�ѡ������Ҫ�����Ĳ���(1--8):\n"); 
                scanf("%d",&n); 
                printf("\n");
            }
            else
             exit(0); 
        } 
}
void menu()/*�˵�����*/ 
{
	printf("        ==******====****��ӭ����ְ����Ϣ����ϵͳ****====******==\n"); 
    printf("           1.¼��ְ����Ϣ"); 
	printf("                 2.���ְ����Ϣ\n"); 
    printf("           3.�����Ų�ѯְ����Ϣ");
    printf("           4.��������ѯְ����Ϣ\n"); 
    printf("           5.��ְ�Ʋ�ѯְ����Ϣ");
    printf("           6.ɾ��ְ����Ϣ\n");  
    printf("           7.�޸�ְ����Ϣ"); 
    printf("                 8.�˳�\n");  
    printf("        ==******====************ллʹ��**********====******==\n"); 
    printf("\n"); 
    printf("\n"); 
}
void input()/*¼�뺯��*/ 
{ 
    int i,m; 
    printf("��������Ҫ������Ϣ��ְ������(1--100):\n"); 
    scanf("%d",&m); 
    for (i=0;i<m;i++) 
    { 
        printf("������ְ���ţ�"); 
        scanf("%d",&em[i].num); 
        printf("����������:  "); 
        scanf("%s",&em[i].name);  
        printf("�������Ա�(f--Ů m--��):  "); 
        scanf("%s",&em[i].sex); 
        printf("�������������:  "); 
        scanf("%d%d%d",&(em[i].birthday.year),&(em[i].birthday.month),&(em[i].birthday.day));  
	
        printf("������ְ��:  "); 
        scanf("%s",&em[i].job); 
        printf("���������״��:  "); 
        scanf("%s",&em[i].marry); 
        printf("������סַ:  "); 
        scanf("%s",&em[i].addr); 
        printf("������绰:  "); 
        scanf("%s",&em[i].tel);
        printf("������e-mail:  ");
        scanf("%s",&em[i].e_addr); 
        printf("\n"); 
    }  
   printf("\n�������!\n"); 
   save(m); 
} 
void save(int m) /*�����ļ�����*/ 
{
     int i; 
     FILE*fp; 
     if ((fp=fopen("employee_list","wb"))==NULL) 
     {
        printf ("cannot open file\n"); 
        exit(0); 
     } 
     for (i=0;i<m;i++) /*���ڴ���ְ������Ϣ����������ļ���ȥ*/ 
      if (fwrite(&em[i],sizeof(struct employee),1,fp)!=1) /*�������ļ�ָ��*fpָ����ļ�д��em[i],���ʧ��,�ʹ�ӡ("file write error\n");Ȼ��ر��ļ�*/
         printf("file write error\n"); 
         fclose(fp); 
} 
int load()/*���뺯��*/ 
{  
    FILE*fp; 
    int i=0;  
    if((fp=fopen("employee_list","rb"))==NULL) 
    {  
        printf ("cannot open file\n"); 
        exit(0); 
    } 
    else  
    {
          do
          {
                 fread(&em[i],sizeof(struct employee),1,fp);
                 i++;
          }  
          while(feof(fp)==0); 
    }  
    fclose(fp);
    return (i-1); 
}
void display()/*�������*/ 
{
      int i; 
      int m=load(); 
      printf("   ְ����\t����\t�Ա�\t\t��������   \n"); 
      for(i=0;i<m;i++) /*mΪ���벿�ֵ�ְ������*/ 
      printf("\n   %d\t\t%s\t%s\t\t%d\t%d\t%d\t\n",em[i].num,em[i].name,em[i].sex,em[i].birthday.year,em[i].birthday.month,em[i].birthday.day);   
      printf("\n  ����״��      ְ��           סַ            �绰            e-mail   \n"); 
      for(i=0;i<m;i++) /*mΪ���벿�ֵ�ְ������*/ 
      printf("\n   %s\t\t%s\t\t%s\t\t%s\t\t%s\n",em[i].marry,em[i].job,em[i].addr,em[i].tel,em[i].e_addr); 
}
void del()/*ɾ������*/ 
{
     int m=load(); 
     int i,j,n,t,flag; 
     char name[20]; 
     printf("\n ԭ����ְ����Ϣ:\n"); 
     display();   
     printf("\n"); 
     printf("������Ҫɾ����ְ��������:\n"); 
     scanf("%s",name); 
     for(flag=1,i=0;flag&&i<m;i++) 
     { 
        if(strcmp(em[i].name,name)==0) 
        { 
            printf("\n���ҵ����ˣ�ԭʼ��¼Ϊ��\n"); 
            printf("   ְ����\t����\t\t�Ա�\t\t��������   \n"); 
            printf("\n   %d\t\t%s\t\t%c\t\t%d\t\n",em[i].num,em[i].name,em[i].sex,em[i].birthday.year,em[i].birthday.month,em[i].birthday.day);   
            printf("\n   ְ�� \t����״��\t\tסַ\t\t�绰\te-mail   \n"); 
            printf("\n   %s\t\t%s\t\t\t%s\t\t%s\t%s\n",em[i].job,em[i].marry,em[i].addr,em[i].tel,em[i].e_addr); 
            printf("\nȷʵҪɾ��������Ϣ�밴1,��ɾ���밴0\n"); 
            scanf("%d",&n); 
               if(n==1)
                {
                     for(j=i;j<m-1;j++)
                     {
                         strcpy(em[j].name,em[j+1].name); 
                         em[j].num=em[j+1].num;
                         //em[j].sex=em[j+1].sex; 
						 strcpy(em[j].sex,em[j+1].sex);
                         em[j].birthday=em[j+1].birthday; 
                         strcpy(em[j].job,em[j+1].job); 
                         //em[j].marry=em[j+1].marry; 
						 strcpy(em[j].marry,em[j+1].marry);
                         strcpy(em[j].addr,em[j+1].addr); 
                         strcpy(em[j].tel,em[j+1].tel);
                         strcpy(em[j].e_addr,em[j+1].e_addr); 
                     } 
                     flag=0; 
                } 
         } 
     }
        if(!flag) 
         m=m-1;
        else 
         printf("\n�Բ��𣬲��޴���!\n"); 
         printf("\n ���ɾ���������ְ����Ϣ:\n"); 
         save(m);   /*���ñ��溯��*/ 
         display();  /*�����������*/ 
         printf("\n����ɾ���밴1������ɾ���밴0\n"); 
         scanf("%d",&t); 
         switch(t) 
         { 
              case 1:del();break; 
              case 0:break; 
              default :break; 
         } 
} 
void search()/*��ѯ����*/ 
{
     int t,flag; 
     do 
     { 
         printf("\n�����Ų�ѯ�밴1;  ��������ѯ�밴2;  ��ְ�Ʋ�ѯ�밴3�������������밴4\n"); 
         scanf("%d",&t); 
         if(t>=1&&t<=4) 
         { 
              flag=1; 
              break; 
         } 
         else 
         { 
              flag=0; 
              printf("����������������ѡ��!");
         }
     } while(flag==0); 
     //while(flag==0); 
     while(flag==1); 
     { 
          switch(t)
          {  
                case 1:printf("�����Ų�ѯ\n");search_num();break; 
                case 2:printf("��������ѯ\n");search_name();break; 
                case 3:printf("��ְ�Ʋ�ѯ\n");search_job();break;
                case 4:main();break; 
                default:break;
          } 
     } 
} 
void search_num() 
{
     int num; 
     int i,t; 
     int m=load(); 
     printf("������Ҫ���ҵĹ���:\n");
     scanf("%d",&num); 
     for(i=0;i<m;i++) {
     if(num==em[i].num) 
     {   
         printf("\n���ҵ����ˣ����¼Ϊ��\n"); 
         printf("   ְ����\t����\t\t�Ա�\t\t��������   \n"); 
         printf("\n   %d\t\t%s\t\t%c\t\t%d\t%d\t%d\t\n",em[i].num,em[i].name,em[i].sex,em[i].birthday.year,em[i].birthday.month,em[i].birthday.day);   
         printf("\n   ְ��\t\t����״��\t\tסַ\t\t�绰\t\te-mail   \n");
         printf("\n   %s\t\t%s\t\t\t%s\t\t%s\t\t%s\n",em[i].job,em[i].marry,em[i].addr,em[i].tel,em[i].e_addr); 
         break; 
     } 
     if(i==m)   
     printf("\n�Բ��𣬲��޴���\n"); 
     printf("\n"); 
     printf("���ز�ѯ�����밴1,������ѯְ�����밴2\n"); 
     scanf("%d",&t); 
     switch(t) 
     {  
         case 1:search();break; 
         case 2: break; 
         default:break; 
     } 
 }
} 
 void search_name() 
{
      char name[20]; 
      int i,t; 
      int m=load(); 
      printf("������Ҫ���ҵ�����:\n"); 
      scanf("%s",&name); 
      for(i=0;i<m;i++) 
      if(strcmp(em[i].name,name)==0) 
      { 
          printf("\n���ҵ������¼Ϊ��\n");
          printf("   ְ����\t����\t\t�Ա�\t\t��������   \n"); 
          printf("\n   %d\t\t%s\t\t%c\t\t%d\t%d\t%d\t\n",em[i].num,em[i].name,em[i].sex,em[i].birthday.year,em[i].birthday.month,em[i].birthday.day);   
          printf("\n   ְ��\t\t����״��\t\tסַ\t\t�绰\t\te-mail   \n");
          printf("\n   %s\t\t%s\t\t\t%s\t\t%s\t\t%s\n",em[i].job,em[i].marry,em[i].addr,em[i].tel,em[i].e_addr); 
          break;
      } 
      if(i==m)  
      printf("\n�Բ��𣬲��޴���\n"); 
      printf("\n"); 
      printf("���ز�ѯ�����밴1,������ѯ�����밴2\n"); 
      scanf("%d",&t); 
      switch(t) 
      {  
           case 1:search();break; 
           case 2:break;
           default :break; 
      } 
} 
void search_job() 
{ 
     char job[30]; 
     int i, t; 
     int m=load(); 
     printf("������Ҫ���ҵ�ְ��:\n"); 
     scanf("%s",&job); 
     for(i=0;i<m;i++) 
     if(strcmp(job,em[i].job)==0)   
     {   
         printf("\n���ҵ����ˣ����¼Ϊ��\n"); 
         printf("   ְ����\t����\t\t�Ա�\t\t��������   \n"); 
         printf("\n   %d\t\t%s\t\t%c\t\t%d\t%d\t%d\t\n",em[i].num,em[i].name,em[i].sex,em[i].birthday.year,em[i].birthday.month,em[i].birthday.day);   
         printf("\n   ְ��\t\t����״��\t\tסַ\t\t�绰\t\te-mail   \n");
         printf("\n   %s\t\t%s\t\t\t%s\t\t%s\t\t%s\n",em[i].job,em[i].marry,em[i].addr,em[i].tel,em[i].e_addr);
         break; 
      }
       if(i==m)   
        printf("\n�Բ��𣬲��޴���\n"); 
        printf("\n"); 
        printf("���ز�ѯ�����밴1,������ѯְ���밴2\n"); 
        scanf("%d",&t); 
        switch(t) 
        {  
             case 1:search();break; 
             case 2:break; 
             default :break; 
        } 
} 
void modify() /*�޸ĺ���*/ 
{ 
     int num; 
     char name[20]; 
     char sex; 
     struct date_type birthday;   
     char marry[30]; 
     char job[30];  
     char addr[30]; 
     char tel[20];
     char e_addr[20]; 
     int b,c,i,n,t,flag;  
     int m=load(); 
     printf("\n ԭ����ְ����Ϣ:\n");
     display();  
     printf("\n"); 
     printf("������Ҫ�޸ĵ�ְ��������:\n"); 
     scanf("%s",name); 
     for(flag=1,i=0;flag&&i<m;i++)
      { 
         if(strcmp(em[i].name,name)==0) 
         { 
              printf("\n���ҵ����ˣ�ԭʼ��¼Ϊ��\n");
              printf("   ְ����\t����\t\t�Ա�\t\t��������   \n"); 
              printf("\n   %d\t\t%s\t\t%c\t\t%d\t%d\t%d\t\n",em[i].num,em[i].name,em[i].sex,em[i].birthday.year,em[i].birthday.month,em[i].birthday.day);   
              printf("\n   ְ��\t\t����״��\tסַ\t\t�绰\te-mail   \n");
              printf("\n   %s\t\t%s\t\t%s\t\t%s\t%s\n",em[i].job,em[i].marry,em[i].addr,em[i].tel,em[i].e_addr);
              printf("\nȷʵҪ�޸Ĵ�����Ϣ�밴1, ���޸��밴0\n"); 
              scanf("%d",&n); 
              if(n==1)
                { 
                      printf("\n��Ҫ�����޸ĵ�ѡ��\n 1.���� 2.���� 3.�Ա� 4.�������� 5.ְ�� 6.����״�� 7.סַ 8.�绰 9.e-mail\n");   
                      printf("�����������޸ĵ���һ�����:\n"); 
                      scanf("%d",&c);   
                      if(c>8||c<1)
                      printf("\nѡ�����������ѡ��!\n");   
                } 
              flag=0; 
         }
      }
       if(flag==1) 
       printf("\n�Բ��𣬲��޴���!\n");   
       do
       { 
           switch(c) /*��Ϊ���ҵ���i��ְ��ʱ,for����i�Լ���1,���������Ӧ�ðѸĺ����Ϣ��ֵ����i-1����*/ 
           { 
                  case 1:printf("ְ���Ÿ�Ϊ: "); 
                         scanf("%d",&num); 
                         em[i-1].num=num; 
                         break;   
                  case 2:printf("������Ϊ: "); 
                         scanf("%s",name); 
                         strcpy(em[i-1].name,name);  
                         break;   
                  case 3:printf("�Ա��Ϊ: "); 
                         getchar(); 
                         scanf("%s",&sex);
                        // em[i-1].sex=sex; 
						   
                         break;   
                  case 4:printf("�������ڸ�Ϊ: "); 
                         scanf("%d%d%d",&em[i-1].birthday.year,&em[i-1].birthday.month,&em[i-1].birthday.day);                
                         break;   
                  case 5:printf("ְ�Ƹ�Ϊ: "); 
                         scanf("%s",&job); 
                         strcpy(em[i-1].job,job);  
                         break;   
                  case 6:printf("���״����Ϊ: ");
                         scanf("%s",&marry); 
                         break;   
                  case 7:printf("סַ��Ϊ: "); 
                         scanf("%s",&addr); 
                         strcpy(em[i-1].addr,addr); 
                         break;   
                  case 8:printf("�绰��Ϊ: "); 
                         scanf("%s",&tel); 
                         strcpy(em[i-1].tel,tel);  
                         break; 
                  case 9:printf("e-mail��Ϊ��");
                         scanf("%s",&e_addr);
                         strcpy(em[i-1].e_addr,e_addr);  
                         break;
           } 
           printf("\n"); 
           printf("\n�Ƿ�ȷ�����޸ĵ���Ϣ?\n ���밴1  ����,�����޸��밴2:  \n");  
           scanf("%d",&b); 
       }   
       while(b==2); 
         printf("\n����޸ĺ������ְ����Ϣ:\n"); 
         printf("\n"); 
         save(m); 
         display(); 
         printf("\n�����޸��밴1�������޸��밴0\n"); 
         scanf("%d",&t);
         switch(t) 
         { 
             case 1:modify();break; 
             case 0:break; 
             default :break; 
         } 
}


 


