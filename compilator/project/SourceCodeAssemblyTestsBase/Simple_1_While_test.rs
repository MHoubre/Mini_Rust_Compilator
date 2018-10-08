/*
Ce qui doit être print:

+5+4+3+2+1+0
*/
fn main () {
	let mut counter= 5;
 	while counter > 0 {
 		print!(counter);
 		let counter= counter-1;
 	}
 	print !(counter);
}