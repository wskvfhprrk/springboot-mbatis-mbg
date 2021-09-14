import instance from './index';
//与后台保持一致的url前置
const preUrlPath = '/AlipayAward';
//获取列表
const list = {
    p: ['get,/roles'],
    r: params => {
        return instance.get(`${r"${"}preUrlPath}/${className}?` + params)
    }
};
const getAll = {
    p: ['get,/menu/list'],
    r: params=> {
        return instance.get(`${r"${"}preUrlPath}/${className}/all`)
    }
};
const remove = {
    p: ['get,/menu/list'],
    r: params => {
        return instance.delete(`${r"${"}preUrlPath}/${className}/${r"${"}params}`)
    }
};
const clock = {
    p: ['get,/menu/list'],
    r: params => {
        return instance.put(`${r"${"}preUrlPath}/${className}/${r"${"}params}`)
    }
}
const click = {
    p: ['get,/menu/list'],
    r: params => {
        return instance.put(`${r"${"}preUrlPath}/click/${r"${"}params}`)
    }
}
const view = {
    p: ['get,/menu/list'],
    r: params => {
        return instance.get(`${r"${"}preUrlPath}/${className}/${r"${"}params}`)
    }
};
const edit = {
    p: ['get,/roles'],
    r: params => {
        return instance.put(`${r"${"}preUrlPath}/${className}`, params)
    }
};
const add = {
    p: ['get,/roles'],
    r: params => {
        return instance.post(`${r"${"}preUrlPath}/${className}`, params)
    }
};
const excelFileF = {
    p: ['get,/menu/list'],
    r: params => {
        return instance.get(`${r"${"}preUrlPath}/couponDown/${r"${"}params}`)
    }
};
export {
    list,
    remove,
    view,
    edit,
    add,
    excelFileF,
    clock,
    click,
    getAll

}
