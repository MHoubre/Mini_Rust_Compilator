struct point{
    x : i32,
    y : & i32
}

fn printnumber(x :point,i:i32){
    print!(x.x);
    print!(*x.y);
}

fn main(){
    let a = 5;
    let b = &a;
    let x = point{x : *b, y : &a};
    let x.x = x.x * *y.y;
    printnumber(x,a);
}
/*
struct sa{
    x : bool,
    y : bool
}
struct sb{
    a : sa,
    c : i32
}

fn add(a : sb, b : i32){
    let a.c = b;
    print!(a);
}

fn main(){
    {
        let d = sa{x:true, y:false};
        let x = sb{a:d, c:3};
        let c = 3;
    };
}*/