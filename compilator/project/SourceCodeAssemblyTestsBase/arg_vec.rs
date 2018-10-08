struct point{
    x : i32
}

fn test(p : point){

print!(p.x);
}

fn test2(v: vec<i32>){

}

fn main(){
let mut a1=125;
let p2= point{x:a1};
let mut b = vec![a1];

test2(b);

}


