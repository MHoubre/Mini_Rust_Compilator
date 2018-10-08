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

struct data2
{
  d: data
}

fn main(){
    let x= data{v:vecteur{x:10, y:10}, to_add:false};
    let x.z = 25;
}