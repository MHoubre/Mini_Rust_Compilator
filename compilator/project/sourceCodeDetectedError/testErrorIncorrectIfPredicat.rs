fn main(){
	let mut test= true;
	let mut i= 0;
	if test {
		let i= i+1;
		let test= i<5;
		if i { /* must trigger error */
			let i= i+1;
			let test= i<5;
		}
	}
	let a = 2 ;
}