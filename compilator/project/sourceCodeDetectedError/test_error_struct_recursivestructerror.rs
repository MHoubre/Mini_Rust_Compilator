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
    let mut x= data{v:vecteur{y:10}, to_add:false};
    let mut x= data{v:vecteur{x:false, y:12}, to_add:false};
    let mut x= data{v:vecteur,to_add:false};
}