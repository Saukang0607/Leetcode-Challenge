/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
    g.sort((a,b) => a - b);
    s.sort((a,b) => a - b);
    const n = g.length, m = s.length;
    var count = 0;
    for(let i =0, j=0; i < n && j<m; i++, j++){
        while(j < m && g[i] > s[j]){ //if the cookies can satisfy the child
            j++;
        }
        if(j < m){ //the child is satisfy
            count++;
        }
    }
    return count;
};