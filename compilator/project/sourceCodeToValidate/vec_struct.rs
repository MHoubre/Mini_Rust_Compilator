struct vecteur
{
    x: i32,
    y: i32
}

struct data
{
    v: vecteur,
    to_add: bool
}

fn main(){
    let x= data{v:vecteur{x:10, y:10}, to_add:false};
    
    let mut v= vec![x];
}
