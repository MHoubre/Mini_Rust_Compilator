fn addition (n1 : i32, n2 : & i32, result : & i32){
     let *result = n1 + *n2;
}

 fn main(){
     let a = 5;
     let b = 5;
     let mut result = 30;
     let presult = &result;
     let *presult = a + b * 5;
     addition(a, &b, &result);
     print!(*presult);
 }