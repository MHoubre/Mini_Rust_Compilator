/*
Ce qui doit être print:

+10+40+9+60+10+1+2+6+7+8+11+10+30-50-12+256+258+100+103+104+5+1+5+4+3+2+1+0
*/
fn main () {
	let mut i = 5;
	let i= i * 2; /* 10 */ 
	let mut v = i * 2 ; /* 20 */

	print !( i );
 	print !( v * 2 );

 	if v == 20 {
 		let mut j= 3 * 3;
 		print !(j);
 		let j= v*3;
 		print !(j);
 	}
 	print !(i);
 	if v >= 19 {
 		print !(1);
 	}
 	if v >= 20 {
 		print !(2);
 	}
 	if v >= 21 {
 		print !(3);
 	}
 	if v == 21 {
 		print !(4);
 	}
 	if v <= 19 {
 		print !(5);
 	}
 	if v <= 20 {
 		print !(6);
 	}
 	if v <= 21 {
 		print !(7);
 	}
 	if v > 19 {
 		print !(8);
 	}
 	if v > 20 {
 		print !(9);
 	}
 	if v < 20 {
 		print !(10);
 	}
 	if v < 21 {
 		print !(11);
 	}
 	if v != 20 {
 		print !(12);
 	}
 	print !(i);
 	let i= i+20;
 	print !(i);
 	let i= i-80;
 	print !(i);
 	let i= i/4;
 	print !(i);
 	if true && true {
 		print !(256);
 	}
 	if true && false {
 		print !(257);
 	}
 	if false || true {
 		print !(258);
 	}
 	if false || false {
 		print !(259);
 	}
 	if i < v {
 		print !(100);
 	}else{
 		print !(101);
 	}
 	if i >= v {
 		print !(102);
 	}else{
 		print !(103);
 	}
 	if i < v {
 		if i >= v {

 		}else{
 			print !(104);
 		}
 	}
 	let mut counter= 5;
 	print !(counter);
 	print !(counter > 0);
 	while counter > 0 {
 		print!(counter);
 		let counter= counter-1;
 	}
 	print !(counter);
}