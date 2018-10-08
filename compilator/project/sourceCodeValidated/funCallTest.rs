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
    return result;
}

fn main() {
    let mut total = 0;
    let mut i = 2;
    let total= {
        let i= i+1;           
        puissance(i,i)
    };
}

/*
------------------0------------------
FUNCTION : puissance - RETURN : i32
ARGSLIST : 
	VAR : a - Mutable - i32	VAR : b - Mutable - i32
FUNCTION : main - RETURN : TYPE_NULL
ARGSLIST : 

-------------------------------------

------------------1------------------
VAR : a - Mutable - i32
VAR : b - Mutable - i32
VAR : i - Mutable - i32
VAR : result - Mutable - i32
-------------------------------------

------------------2------------------
-------------------------------------

------------------3------------------
-------------------------------------

------------------4------------------
VAR : total - Mutable - i32
VAR : i - Mutable - i32
-------------------------------------

------------------5------------------
-------------------------------------
*/
