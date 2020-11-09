import java.util.Arrays;

public class RotaTest {

    public static void main(String[] args) {
	
	Rotations r = new Rotations();
	
	// take one representative, then get its orbit
	Byte[] orb1 = new Byte[]{r.rotation0(-1, -1), r.rotation1(-1, -1), r.rotation2(-1, -1), r.rotation3(-1, -1)}; 
	Byte[] orb2 = new Byte[]{r.rotation0(-2, -2), r.rotation1(-2, -2), r.rotation2(-2, -2), r.rotation3(-2, -2)};
	Byte[] orb3 = new Byte[]{r.rotation0(-2, -1), r.rotation1(-2, -1), r.rotation2(-2, -1), r.rotation3(-2, -1)};
	Byte[] orb4 = new Byte[]{r.rotation0(-2, 1), r.rotation1(-2, 1), r.rotation2(-2, 1), r.rotation3(-2, 1)};
	Byte[] orb5 = new Byte[]{r.rotation0(-3, -3), r.rotation1(-3, -3), r.rotation2(-3, -3), r.rotation3(-3, -3)};
	Byte[] orb6 = new Byte[]{r.rotation0(-3, -2), r.rotation1(-3, -2), r.rotation2(-3, -2), r.rotation3(-3, -2)};
	Byte[] orb7 = new Byte[]{r.rotation0(-3, -1), r.rotation1(-3, -1), r.rotation2(-3, -1), r.rotation3(-3, -1)};
	Byte[] orb8 = new Byte[]{r.rotation0(-3, 1), r.rotation1(-3, 1), r.rotation2(-3, 1), r.rotation3(-3, 1)};
	Byte[] orb9 = new Byte[]{r.rotation0(-3, 2), r.rotation1(-3, 2), r.rotation2(-3, 2), r.rotation3(-3, 2)};
	
	for(int i1 : orb1) System.out.print(i1 + " ");
	System.out.print("\n");
	for(int i1 : orb2) System.out.print(i1 + " ");
	System.out.print("\n");
	for(int i1 : orb3) System.out.print(i1 + " ");
	System.out.print("\n");
	for(int i1 : orb4) System.out.print(i1 + " ");
	System.out.print("\n");
	for(int i1 : orb5) System.out.print(i1 + " ");
	System.out.print("\n");
	for(int i1 : orb6) System.out.print(i1 + " ");
	System.out.print("\n");
	for(int i1 : orb7) System.out.print(i1 + " ");
	System.out.print("\n");
	for(int i1 : orb8) System.out.print(i1 + " ");
	System.out.print("\n");
	for(int i1 : orb9) System.out.print(i1 + " ");
	
    }
    
}
