export function dataMask(val: any) {
    var pass = val;
    var expr = /[0123456789]/;
  
    try {
      for (let i = 0; i < pass.length; i++) {
        var lchar = pass.charAt(i);
        var nchar = pass.charAt(i + 1);
        if (i === 0) {
          if (lchar.search(expr) !== 0 || lchar > 3) {
            pass = '';
          }
        } else if (i === 1) {
          if (lchar.search(expr) !== 0) {
            var tst1 = pass.substring(0, i);
            pass = tst1;
            continue;
          }
  
          if (nchar !== '/' && nchar !== '') {
            var tst1 = pass.substring(0, i + 1);
  
            if (nchar.search(expr) !== 0)
              var tst2 = pass.substring(i + 2, pass.length);
            else var tst2 = pass.substring(i + 1, pass.length);
  
            pass = tst1 + '/' + tst2;
          }
        } 
      }
  
      if (pass.length > 7) {
        pass = pass.substring(0, 7);
      }
      return pass;
    } catch (error) {
      console.log(error);
      return
    }
  }