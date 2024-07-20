import java.util.Scanner; //นำเข้าโปรแกรม Scanner

public class Registerandlogin { // สร้าง class ชื่อว่า Register and login

    public static void main(String[] args) {

        String[][] userDatabase = new String[10][2]; /*
                                                      * ประกาศตัวแปร Array ที่เป็น 2D โดยแต่ละแถวเก็บข้อมูลของผู้ใช้
                                                      * และคอลัมน์แรกเก็บ username และคอลัมน์ที่สองเก็บ password
                                                      */

        Scanner input = new Scanner(System.in); // ใช้ Method ของ Scanner

        int userCount = 0; // ประกาศค่าตัวแปร userCount เพื่อเก็บจำนวนของผู้ใช้ที่มีอยู่ในระบบ
        String TF = ""; // ประกาศค่าตัวแปร TF เพื่อเก็บค่าที่เป็น Y และ N
        String username = ""; // ประกาศค่าตัวแปร username เพื่อเก็บข้อมูลชื่อผู้ใช้งาน
        String password = ""; // ประกาศค่าตัวแปร password เพื่อเก็บรหัสของผู้ใช้งาน

        System.out.print("\nWould you like to do it or not? Y/N: "); /*
                                                           * ส่งออกเพื่อถาม user
                                                           * ว่าต้องการเข้าทำการในโปรแกรมนี้ใช่หรือไม่
                                                           */
        TF = input.nextLine().toUpperCase(); // รับค่า input จาก user ที่เป็นข้อความแล้วทำการแปลงเป็นตัวพิมพ์ใหญ่ทั้งหมด

        if (TF.equals("Y") || TF.equals("N")) { // ถ้าเข้าเงื่อนไขนี้จะเริ่มการทำงาน

            while (TF.equals("Y")) { // เข้าเงื่อนไขเมื่อตัวแปร TF มีค่าเท่ากับ Y
                System.out.println("\nSelect to do."); // ส่งออกข้อความให้ user
                System.out.println("1: Login"); // ส่งออกตัวเลือกให้ user
                System.out.println("2: Register"); // ส่งออกตัวเลือกให้ user
                System.out.print(" \nYour answer: "); // กรอกคำตอบ
                int choice = input.nextInt(); // รับค่าตัวเลือกที่เป็นจำนวนเต็มจาก user
                input.nextLine(); // อ่านข้อมูลเพิ่มเติมหลังจากอ่านตัวเลข

                if (choice == 1 || choice == 2) { // ตั้งเงื่อนไขให้ค่าที่รับมา เป็น 1 หรือ 2 ถ้าเป็นก็ดำเนินการต่อ

                    switch (choice) { // ใช้ switch เพื่อเลือก 1 ในตัวเลือกจากทั้งหมด

                        case 1: // เคสที่ 1 เป็นการ log in
                            System.out.print("\nUsername: "); // กรอก username
                            username = input.nextLine(); // รับค่า username จาก user
                            System.out.print("Password: "); // กรอก password
                            password = input.nextLine(); // รับค่า password จาก user

                            for (int i = 0; i < userCount; i++) { /*
                                                                   * การทำ Loop เพื่อเช็คว่า username และ password
                                                                   * ตรงกับที่มีอยู่ในระบบจากการลงทะเบียนหรือไม่
                                                                   */
                                if (userDatabase[i][0].equals(username) && userDatabase[i][1].equals(password)) {
                                    System.out.println("\nLogin successful!\n"); /*
                                                                                   * ถ้าตรงเงื่อนไขจะขึ้นว่า log in
                                                                                   * สำเร็จ
                                                                                   */
                                    System.out.println("Welcome\n");
                                    return; // จบการทำงานของโปรแกรม
                                }

                            }
                            System.out.println(
                                    "\n* Login failed Because the user account was not found Please try again. *"); /*
                                                                                                               * ถ้าไม่เข้าเงืื่อนไข
                                                                                                               * จะขึ้นว่า
                                                                                                               * log in
                                                                                                               * ไม่สำเร็จและจะวนเข้า
                                                                                                               * Loop
                                                                                                               * เลือกการทำการอีกครั้ง
                                                                                                               * เพื่อให้
                                                                                                               * user
                                                                                                               * ทำการลงทะเบียนก่อนlog
                                                                                                               * in
                                                                                                               */
                            break;

                        case 2: // เคสที่ 2 เป็นการ Register ก่อนเข้า log in เพื่อเก็บข้อมูลเข้าสู่ Array
                            System.out.print("\nUsername: "); // รับค่า username จาก user
                            username = input.nextLine();
                            for (int i = 0; i < userCount; i++) { /*
                                                                   * เข้า Loop เพื่อเช็คว่า username ที่ user
                                                                   * กรอกนั้นมีอยู่แล้วในระบบหรือไม่
                                                                   */
                                if (userDatabase[i][0].equals(username)) { /*
                                                                            * ถ้ามีอยู่ในระบบแล้วจะขึ้นว่า
                                                                            * มีผู้ใช้ชื่อนี้แล้วเพื่อป้องกันข้อมูลซ้ำเพราะจะส่งผลต่อ
                                                                            * password
                                                                            */
                                    System.out.println("\n* This username is already in use. Please use another name. *");
                                    do { // เข้า Loop ให้กรอก username ใหม่ที่ไม่ซ้ำ
                                        System.out.print("\nUsername: ");
                                        username = input.nextLine();

                                    } while (userDatabase[i][0].equals(username)); /*
                                                                                    * ถ้าไม่ซ้ำกับในระบบแล้วจะออกจาก
                                                                                    * Loop
                                                                                    */
                                }

                            }

                            System.out.print("Password: "); // ตั้งรหัสเพื่อเข้าสู่ระบบ
                            password = input.nextLine();

                            userDatabase[userCount][0] = username; // เก็บ username ใน column แรก คือ index [0]
                            userDatabase[userCount][1] = password; // เก็บ password ใน column ที่สอง คือ index [1]
                            userCount++; // เพิ่มค่าจำนวนผู้ใช้งาน
                            System.out.println("\nSuccessfully registered!"); // เมื่อกรอกครบหมดแล้วจะขึ้นว่า ลงทะเบียนสำเร็จ
                            break;

                        default: // user กรอกไม่ตรงกับเคสใด ๆ จะทำการออกจากโปรแกรมทันที
                            System.out.println("\nExit the program\n");
                            return; // จบการทำงานของโปรแกรม
                    }
                } else {
                    System.err.println("\n*** Please select 1 or 2. ***"); /*
                                                                          * ถ้าไม่เข้าเงื่อนไข ที่เลือก ระหว่าง 1 กับ 2
                                                                          * ให้ print คำสั่งนี้ และทำการตอบใหม่
                                                                          */
                }
            }
            if (TF.equals("N")) { // เข้าเงื่อนไขเมื่อตัวแปร TF มีค่าเท่ากับ N
                System.out.println("\nExit the program\n");
                return; // จบการทำงานของโปรแกรม
            }
        } else {
            System.err.println("\n*** Log out because the question was not answered correctly. ***\n");

        }
    }
}