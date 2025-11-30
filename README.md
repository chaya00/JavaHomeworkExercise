

# JavaHomeworkExercise – Task Manager System

מערכת לניהול משימות (Todo List) המבוססת על Java Standard Edition וללא שימוש בספריות חיצוניות.  
המערכת שומרת נתונים מקומית בקובץ JSON ומדגימה עבודה עם שכבות **Repository**, **Service** ו־**UI קונסולי**.

---

## תכולת הפרויקט
- **Model** – מחלקות נתונים (`Task`, `Status` enum)  
- **Repository** – ניהול משימות על גבי קובץ JSON  
- **Service** – לוגיקה עסקית (חיפוש, מיון, עדכון סטטוס)  
- **Main (UI)** – ממשק טקסטואלי בסיסי להפעלת המערכת  
- **פתרון אלגוריתמי** – הפקת כל תתי־הרצפים העולים במערך  
- **Design Document** – תכנון REST API ומערכת הזמנות/תשלומים  

---

## דרישות מערכת
- Java **JDK 11** ומעלה  
- כל IDE תואם Java (מומלץ IntelliJ)

---

## הורדת הפרויקט

### 1. הורדה כ־ZIP
1. היכנס לקישור:  
   https://github.com/chaya00/JavaHomeworkExercise
2. לחץ **Code**  
3. בחר **Download ZIP**  
4. חלץ את הקובץ למחשב  

### 2. Clone דרך Git
   bash git clone https://github.com/chaya00/JavaHomeworkExercise.git

## הרצה בתוך IntelliJ
1. פתח את תיקיית הפרויקט (File → Open). 

2. ודא שה־SDK מוגדר ל־JDK 11 (File → Project Structure).

3. בצע Build → Build Project.

4. אתר את:
Tasks/Main.java
ולחץ → Run.

המערכת מאפשרת:

Add

Update

Delete

GetById

ListAll

MarkDone

Search

ListByStatus

הרצה משורת פקודה
javac Tasks/*.java
java Tasks.Main
מידע נוסף
קובץ ה־JSON נוצר אוטומטית אם אינו קיים.

הנתונים נשמרים מקומית בלבד (File I/O).

ללא שימוש בספריות חיצוניות – Java SE בלבד.
 # קובץ הכניסה 
Tasks/Main.java
