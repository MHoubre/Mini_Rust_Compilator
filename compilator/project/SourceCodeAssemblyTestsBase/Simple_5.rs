/*
Ce qui doit être print:

+40+41
*/
fn test ( a : i32 , b : i32 ) -> i32
 {
	let mut c = a * b ;
	return c;
}

fn comp ( d : i32 ) {

	if d < 50 {
		print ! (d+1);
	}
}


fn main() {
	let y = 2;
	let mut b = test(y*2, 10); /* renvoi 40 */
	print!(b);
	comp(b);
}