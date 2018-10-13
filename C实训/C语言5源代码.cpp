#include <stdio.h>
#include <windows.h>
#include <string.h>
#define N 100
struct date_type //定义出生年月// 
{
	int year;
	int month;
	int day;
}; 
struct employee  /*定义一个结构体*/ 
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
void modify();  /*定义各函数*/ 
int main() 
{
	   
    int n,flag; 
    char a;
	menu();
    
	  do{
	      printf("请选择你需要操作的步骤(1--8):\n"); 
       scanf("%d",&n); 
       if(n>=1&&n<=7) 
        {
	       flag=1; 
        } 
       else
        {  
           flag=0;  
           printf("您输入有误，请重新选择!");  
        } 
    	}	while(flag==0);
      
    //while(flag==0); 
    while(flag==1)
        {
            switch(n) 
            {
	            case 1:printf("     ***输入职工信息***     \n");
				       printf("\n");input();break;  
                case 2:printf("     ***浏览职工信息***     \n");
	                   printf("\n");display();break; 
			    case 3:printf("     ***按工号查询职工信息***     \n");
			       	   printf("\n");search_num();break;
                case 4:printf("     ***按性名查询职工信息***     \n");
			       	   printf("\n");search_name();break;            
   	            case 5:printf("     ***按职称查询职工信息***     \n");
			       	   printf("\n");search_job();break;            
				case 6:printf("     ***删除职工信息***     \n");
				       printf("\n");del();break;
				case 7:printf("     ***修改职工信息***     \n");
				       printf("\n"); modify();break;   
                case 8:exit(0);break; 
                      default :break; 
            }  
            getchar(); 
            printf("\n");  
            printf("是否继续进行(y or n):\n"); 
			scanf("%c",&a); 
            if(a=='y') 
            {
	            flag=1;
				system("cls");/*清屏*/ 
				menu();/*调用菜单函数*/  
                printf("请再次选择你需要操作的步骤(1--8):\n"); 
                scanf("%d",&n); 
                printf("\n");
            }
            else
             exit(0); 
        } 
}
void menu()/*菜单函数*/ 
{
	printf("        ==******====****欢迎进入职工信息管理系统****====******==\n"); 
    printf("           1.录入职工信息"); 
	printf("                 2.浏览职工信息\n"); 
    printf("           3.按工号查询职工信息");
    printf("           4.按姓名查询职工信息\n"); 
    printf("           5.按职称查询职工信息");
    printf("           6.删除职工信息\n");  
    printf("           7.修改职工信息"); 
    printf("                 8.退出\n");  
    printf("        ==******====************谢谢使用**********====******==\n"); 
    printf("\n"); 
    printf("\n"); 
}
void input()/*录入函数*/ 
{ 
    int i,m; 
    printf("请输入需要创建信息的职工人数(1--100):\n"); 
    scanf("%d",&m); 
    for (i=0;i<m;i++) 
    { 
        printf("请输入职工号："); 
        scanf("%d",&em[i].num); 
        printf("请输入姓名:  "); 
        scanf("%s",&em[i].name);  
        printf("请输入性别(f--女 m--男):  "); 
        scanf("%s",&em[i].sex); 
        printf("请输入出生日期:  "); 
        scanf("%d%d%d",&(em[i].birthday.year),&(em[i].birthday.month),&(em[i].birthday.day));  
	
        printf("请输入职称:  "); 
        scanf("%s",&em[i].job); 
        printf("请输入婚姻状况:  "); 
        scanf("%s",&em[i].marry); 
        printf("请输入住址:  "); 
        scanf("%s",&em[i].addr); 
        printf("请输入电话:  "); 
        scanf("%s",&em[i].tel);
        printf("请输入e-mail:  ");
        scanf("%s",&em[i].e_addr); 
        printf("\n"); 
    }  
   printf("\n创建完毕!\n"); 
   save(m); 
} 
void save(int m) /*保存文件函数*/ 
{
     int i; 
     FILE*fp; 
     if ((fp=fopen("employee_list","wb"))==NULL) 
     {
        printf ("cannot open file\n"); 
        exit(0); 
     } 
     for (i=0;i<m;i++) /*将内存中职工的信息输出到磁盘文件中去*/ 
      if (fwrite(&em[i],sizeof(struct employee),1,fp)!=1) /*依次向文件指针*fp指向的文件写入em[i],如果失败,就打印("file write error\n");然后关闭文件*/
         printf("file write error\n"); 
         fclose(fp); 
} 
int load()/*导入函数*/ 
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
void display()/*浏览函数*/ 
{
      int i; 
      int m=load(); 
      printf("   职工号\t姓名\t性别\t\t出生日期   \n"); 
      for(i=0;i<m;i++) /*m为输入部分的职工人数*/ 
      printf("\n   %d\t\t%s\t%s\t\t%d\t%d\t%d\t\n",em[i].num,em[i].name,em[i].sex,em[i].birthday.year,em[i].birthday.month,em[i].birthday.day);   
      printf("\n  婚姻状况      职称           住址            电话            e-mail   \n"); 
      for(i=0;i<m;i++) /*m为输入部分的职工人数*/ 
      printf("\n   %s\t\t%s\t\t%s\t\t%s\t\t%s\n",em[i].marry,em[i].job,em[i].addr,em[i].tel,em[i].e_addr); 
}
void del()/*删除函数*/ 
{
     int m=load(); 
     int i,j,n,t,flag; 
     char name[20]; 
     printf("\n 原来的职工信息:\n"); 
     display();   
     printf("\n"); 
     printf("请输入要删除的职工的姓名:\n"); 
     scanf("%s",name); 
     for(flag=1,i=0;flag&&i<m;i++) 
     { 
        if(strcmp(em[i].name,name)==0) 
        { 
            printf("\n已找到此人，原始记录为：\n"); 
            printf("   职工号\t姓名\t\t性别\t\t出生日期   \n"); 
            printf("\n   %d\t\t%s\t\t%c\t\t%d\t\n",em[i].num,em[i].name,em[i].sex,em[i].birthday.year,em[i].birthday.month,em[i].birthday.day);   
            printf("\n   职称 \t婚姻状况\t\t住址\t\t电话\te-mail   \n"); 
            printf("\n   %s\t\t%s\t\t\t%s\t\t%s\t%s\n",em[i].job,em[i].marry,em[i].addr,em[i].tel,em[i].e_addr); 
            printf("\n确实要删除此人信息请按1,不删除请按0\n"); 
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
         printf("\n对不起，查无此人!\n"); 
         printf("\n 浏览删除后的所有职工信息:\n"); 
         save(m);   /*调用保存函数*/ 
         display();  /*调用浏览函数*/ 
         printf("\n继续删除请按1，不再删除请按0\n"); 
         scanf("%d",&t); 
         switch(t) 
         { 
              case 1:del();break; 
              case 0:break; 
              default :break; 
         } 
} 
void search()/*查询函数*/ 
{
     int t,flag; 
     do 
     { 
         printf("\n按工号查询请按1;  按姓名查询请按2;  按职称查询请按3；进入主函数请按4\n"); 
         scanf("%d",&t); 
         if(t>=1&&t<=4) 
         { 
              flag=1; 
              break; 
         } 
         else 
         { 
              flag=0; 
              printf("您输入有误，请重新选择!");
         }
     } while(flag==0); 
     //while(flag==0); 
     while(flag==1); 
     { 
          switch(t)
          {  
                case 1:printf("按工号查询\n");search_num();break; 
                case 2:printf("按姓名查询\n");search_name();break; 
                case 3:printf("按职称查询\n");search_job();break;
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
     printf("请输入要查找的工号:\n");
     scanf("%d",&num); 
     for(i=0;i<m;i++) {
     if(num==em[i].num) 
     {   
         printf("\n已找到此人，其记录为：\n"); 
         printf("   职工号\t姓名\t\t性别\t\t出生日期   \n"); 
         printf("\n   %d\t\t%s\t\t%c\t\t%d\t%d\t%d\t\n",em[i].num,em[i].name,em[i].sex,em[i].birthday.year,em[i].birthday.month,em[i].birthday.day);   
         printf("\n   职称\t\t婚姻状况\t\t住址\t\t电话\t\te-mail   \n");
         printf("\n   %s\t\t%s\t\t\t%s\t\t%s\t\t%s\n",em[i].job,em[i].marry,em[i].addr,em[i].tel,em[i].e_addr); 
         break; 
     } 
     if(i==m)   
     printf("\n对不起，查无此人\n"); 
     printf("\n"); 
     printf("返回查询函数请按1,继续查询职工号请按2\n"); 
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
      printf("请输入要查找的姓名:\n"); 
      scanf("%s",&name); 
      for(i=0;i<m;i++) 
      if(strcmp(em[i].name,name)==0) 
      { 
          printf("\n已找到，其记录为：\n");
          printf("   职工号\t姓名\t\t性别\t\t出生日期   \n"); 
          printf("\n   %d\t\t%s\t\t%c\t\t%d\t%d\t%d\t\n",em[i].num,em[i].name,em[i].sex,em[i].birthday.year,em[i].birthday.month,em[i].birthday.day);   
          printf("\n   职称\t\t婚姻状况\t\t住址\t\t电话\t\te-mail   \n");
          printf("\n   %s\t\t%s\t\t\t%s\t\t%s\t\t%s\n",em[i].job,em[i].marry,em[i].addr,em[i].tel,em[i].e_addr); 
          break;
      } 
      if(i==m)  
      printf("\n对不起，查无此人\n"); 
      printf("\n"); 
      printf("返回查询函数请按1,继续查询姓名请按2\n"); 
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
     printf("请输入要查找的职称:\n"); 
     scanf("%s",&job); 
     for(i=0;i<m;i++) 
     if(strcmp(job,em[i].job)==0)   
     {   
         printf("\n已找到此人，其记录为：\n"); 
         printf("   职工号\t姓名\t\t性别\t\t出生日期   \n"); 
         printf("\n   %d\t\t%s\t\t%c\t\t%d\t%d\t%d\t\n",em[i].num,em[i].name,em[i].sex,em[i].birthday.year,em[i].birthday.month,em[i].birthday.day);   
         printf("\n   职称\t\t婚姻状况\t\t住址\t\t电话\t\te-mail   \n");
         printf("\n   %s\t\t%s\t\t\t%s\t\t%s\t\t%s\n",em[i].job,em[i].marry,em[i].addr,em[i].tel,em[i].e_addr);
         break; 
      }
       if(i==m)   
        printf("\n对不起，查无此人\n"); 
        printf("\n"); 
        printf("返回查询函数请按1,继续查询职称请按2\n"); 
        scanf("%d",&t); 
        switch(t) 
        {  
             case 1:search();break; 
             case 2:break; 
             default :break; 
        } 
} 
void modify() /*修改函数*/ 
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
     printf("\n 原来的职工信息:\n");
     display();  
     printf("\n"); 
     printf("请输入要修改的职工的姓名:\n"); 
     scanf("%s",name); 
     for(flag=1,i=0;flag&&i<m;i++)
      { 
         if(strcmp(em[i].name,name)==0) 
         { 
              printf("\n已找到此人，原始记录为：\n");
              printf("   职工号\t姓名\t\t性别\t\t出生日期   \n"); 
              printf("\n   %d\t\t%s\t\t%c\t\t%d\t%d\t%d\t\n",em[i].num,em[i].name,em[i].sex,em[i].birthday.year,em[i].birthday.month,em[i].birthday.day);   
              printf("\n   职称\t\t婚姻状况\t住址\t\t电话\te-mail   \n");
              printf("\n   %s\t\t%s\t\t%s\t\t%s\t%s\n",em[i].job,em[i].marry,em[i].addr,em[i].tel,em[i].e_addr);
              printf("\n确实要修改此人信息请按1, 不修改请按0\n"); 
              scanf("%d",&n); 
              if(n==1)
                { 
                      printf("\n需要进行修改的选项\n 1.工号 2.姓名 3.性别 4.出生日期 5.职称 6.婚姻状况 7.住址 8.电话 9.e-mail\n");   
                      printf("请输入你想修改的那一项序号:\n"); 
                      scanf("%d",&c);   
                      if(c>8||c<1)
                      printf("\n选择错误，请重新选择!\n");   
                } 
              flag=0; 
         }
      }
       if(flag==1) 
       printf("\n对不起，查无此人!\n");   
       do
       { 
           switch(c) /*因为当找到第i个职工时,for语句后i自加了1,所以下面的应该把改后的信息赋值给第i-1个人*/ 
           { 
                  case 1:printf("职工号改为: "); 
                         scanf("%d",&num); 
                         em[i-1].num=num; 
                         break;   
                  case 2:printf("姓名改为: "); 
                         scanf("%s",name); 
                         strcpy(em[i-1].name,name);  
                         break;   
                  case 3:printf("性别改为: "); 
                         getchar(); 
                         scanf("%s",&sex);
                        // em[i-1].sex=sex; 
						   
                         break;   
                  case 4:printf("出生日期改为: "); 
                         scanf("%d%d%d",&em[i-1].birthday.year,&em[i-1].birthday.month,&em[i-1].birthday.day);                
                         break;   
                  case 5:printf("职称改为: "); 
                         scanf("%s",&job); 
                         strcpy(em[i-1].job,job);  
                         break;   
                  case 6:printf("结婚状况改为: ");
                         scanf("%s",&marry); 
                         break;   
                  case 7:printf("住址改为: "); 
                         scanf("%s",&addr); 
                         strcpy(em[i-1].addr,addr); 
                         break;   
                  case 8:printf("电话改为: "); 
                         scanf("%s",&tel); 
                         strcpy(em[i-1].tel,tel);  
                         break; 
                  case 9:printf("e-mail改为：");
                         scanf("%s",&e_addr);
                         strcpy(em[i-1].e_addr,e_addr);  
                         break;
           } 
           printf("\n"); 
           printf("\n是否确定所修改的信息?\n 是请按1  不是,重新修改请按2:  \n");  
           scanf("%d",&b); 
       }   
       while(b==2); 
         printf("\n浏览修改后的所有职工信息:\n"); 
         printf("\n"); 
         save(m); 
         display(); 
         printf("\n继续修改请按1，不再修改请按0\n"); 
         scanf("%d",&t);
         switch(t) 
         { 
             case 1:modify();break; 
             case 0:break; 
             default :break; 
         } 
}


 


