fn main(){
	let mut test= true;
	let mut i= 0;
	while test {
		let i= i+1;
		let test= i<5;
		while i { /* must trigger error */
			let i= i+1;
			let test= i<5;
		}
	}
}