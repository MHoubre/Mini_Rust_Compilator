/*
Ce qui doit être print:

+5
*/
fn main () {
    let mut total = 0;
    let mut i = 0;
    let n = 2;
    let mut test = i <= n ;
    while test {
        let total = total + i * i;
        let i = i + 1;
        let test = i <= n;
    }
    print !( total );
}