fn puissance(a : i32, b : i32) -> i32
{
    if b == 0
    {
        return 1;
    }

    let mut i = 1;
    let mut result = a;
    while i < b
    {
        let result = result * a;
        let i = i + 1;
    }
    return false; /* doit lever erreur cf false pas de type i32 */
}

fn main() {
    let mut total = true;
    let mut i = 2;
    let total= {
        let i= i+1;           
        puissance(i,i)
    }; /* doit lever erreur cf retour bloc i32 et total type bool*/
}
